package yahu.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yahu.in.entity.Rating;
import yahu.in.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingRestController {
	
	private RatingService rs;
	public RatingRestController(RatingService rs) {
		this.rs=rs;
	}
	
	@PostMapping
	public ResponseEntity<Rating> addOne (@RequestBody Rating r){
		return ResponseEntity.status(HttpStatus.CREATED).body(rs.addOne(r));
	}
	
	@DeleteMapping ("/users/{userId}")
	public ResponseEntity<String> deleteOneUser (@PathVariable ("userId") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(rs.deleteOneByUserId(userId));
	}
	
	@DeleteMapping ("/hotel/{HotelId}")
	public ResponseEntity<String> deleteOneHotel (@PathVariable ("HotelId") String HotelId){
		return ResponseEntity.status(HttpStatus.OK).body(rs.deleteOneByHotelId(HotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll () {
		return ResponseEntity.status(HttpStatus.OK).body(rs.getAll());
	}
	
	@GetMapping ("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllUser (@PathVariable ("userId") String userId) {
		List<Rating> allByUserId = rs.getAllByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(allByUserId);
	}
	
	@GetMapping ("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllHotel (@PathVariable("hotelId") String hotelId) {
		List<Rating> allByHotelId = rs.getAllByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(allByHotelId);
	}
	

}
