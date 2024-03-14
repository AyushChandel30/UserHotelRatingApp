package yahu.in.service;

import java.util.List;

import yahu.in.entity.User;

public interface UserService {
	
	User saveUser(User user);
	User getOneUser (String userId);
	List<User> getAllUser ();
	String deleteOne (String userId);

}
