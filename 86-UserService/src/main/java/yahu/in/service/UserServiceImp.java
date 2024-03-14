package yahu.in.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import yahu.in.binding.UserHotelBinding;
import yahu.in.binding.UserRatingBinding;
import yahu.in.entity.User;
import yahu.in.exception.ResourceNotFoundException;
import yahu.in.repo.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private UserRepository ur;

	public UserServiceImp(UserRepository ur) {
		this.ur = ur;
	}

	// RestTemplate rt = new RestTemplate();
	// or
	@Autowired
	private RestTemplate rt;
	
	//private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	@Override
	public User saveUser(User user) {
		// generating unique id
		String string = UUID.randomUUID().toString();
		user.setUserId(string);
		return ur.save(user);
	}

//	@Override
//	public User getOneUser(String userId) {
//		// getting user info from user table
//		User user = ur.findById(userId).orElseThrow(
//				() -> new ResourceNotFoundException("User with given id is not found on server :: " + userId));
//		// getting rating done by user from rating service
//		String url = "http://localhost:4003/rating/users/" + userId;
//		ResponseEntity<UserRatingBinding[]> rting = rt.getForEntity(url, UserRatingBinding[].class);
//		UserRatingBinding[] body = rting.getBody();
//		List<UserRatingBinding> asList = Arrays.asList(body);
//		user.setRating(asList);
//		return user;
//	} OR
	@Override
	public User getOneUser(String userId) {
		// getting user info from user table
		User user = ur.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server :: " + userId));
		// getting rating done by user from rating service
		String url = "http://RATINGSERVICE/rating/users/" + user.getUserId();
		UserRatingBinding[] ratingOfUser = rt.getForObject(url, UserRatingBinding[].class);
		//converting Rating object to List
		List<UserRatingBinding> ratings = Arrays.stream(ratingOfUser).toList();
		//getting hotel on which rating is done
		List<UserRatingBinding> ratingList = ratings.stream().map(oneRatingFromRatingList -> {
			String url2= "http://HOTELSERVICE/hotel/" + oneRatingFromRatingList.getHotelId();
			ResponseEntity<UserHotelBinding> lulu = rt.getForEntity(url2, UserHotelBinding.class);
			UserHotelBinding hotel = lulu.getBody();
			oneRatingFromRatingList.setRh(hotel);
			return oneRatingFromRatingList;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}
	
	@Override 
	public List<User> getAllUser() {
		List<User> userList = ur.findAll();
		return userList;
	}

	@Override
	public String deleteOne(String userId) {
		ur.deleteById(userId);
		return "User Deleted";
	}

}
