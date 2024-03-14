package yahu.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yahu.in.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	//custom finder methods
	List<Rating> findByUserId (String userId);
	List<Rating> findByHotelId (String hotelId);
	String deleteByUserId (String userId);
	String deleteByHotelId (String hotelId);
	//method name should match to the variable name in Rating class
	//ex. "deleteByHotelId" is correct
	//		"deleteByIdHotel" is wrong
}
