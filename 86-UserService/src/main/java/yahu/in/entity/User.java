package yahu.in.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yahu.in.binding.UserRatingBinding;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
public class User {

	@Id
	@Column (name="ID")
	private String userId;
	
	@Column (name="NAME", length=20)
	private String name;
	
	@Column (name="EMAIL")
	private String email;
	
	@Column (name="ABOUT")
	private String about;
	
	@Transient //DB should ignore this
	private List<UserRatingBinding> ratings = new ArrayList<>();
	//UserRatingBinding[] rating;
}
