package yahu.in.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import yahu.in.entity.Rating;
import yahu.in.repo.RatingRepository;

@Service
public class RatingServiceImp implements RatingService{

	private RatingRepository rr;
	public RatingServiceImp (RatingRepository rr) {
		this.rr=rr;
	}
	
	@Override
	public Rating addOne(Rating r) {
		String s = UUID.randomUUID().toString();
		r.setRatingId(s);
		return rr.save(r);
	}

	@Override
	public String deleteOneByUserId(String userId) {
		rr.deleteByUserId(userId);
		return "Record deleted by User id";
	}

	@Override
	public String deleteOneByHotelId(String hotelId) {
		rr.deleteByHotelId(hotelId);
		return "Record deleted by hotel id";
	}

	@Override
	public List<Rating> getAll() {
		return rr.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String UserId) {
		return rr.findByUserId(UserId);
	}

	@Override
	public List<Rating> getAllByHotelId(String HotelId) {
		return rr.findByHotelId(HotelId);
	}

}
