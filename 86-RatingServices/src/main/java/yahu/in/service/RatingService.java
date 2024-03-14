package yahu.in.service;

import java.util.List;

import yahu.in.entity.Rating;

public interface RatingService {
	
	//adding
	Rating addOne (Rating r);
	//deleting
	String deleteOneByUserId (String userId);
	String deleteOneByHotelId (String hotelId);
	//getting
	List<Rating> getAll ();
	List<Rating> getAllByUserId(String UserId);
	List<Rating> getAllByHotelId (String HotelId);

}
