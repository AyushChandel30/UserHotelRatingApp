package yahu.in.binding;

import lombok.Data;

@Data
public class UserRatingBinding {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	private UserHotelBinding rh;
	//private List<UserHotelBinding> rh = new ArrayList<>();
	
}
