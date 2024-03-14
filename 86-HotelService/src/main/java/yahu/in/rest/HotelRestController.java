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

import yahu.in.entity.Hotel;
import yahu.in.service.HotelService;

@RestController
@RequestMapping ("/hotel")
public class HotelRestController {
	
	private HotelService hs;
	public HotelRestController(HotelService hs) {
		this.hs=hs;
	}
	
	@PostMapping
	public ResponseEntity<Hotel> addOne (@RequestBody Hotel h){
		Hotel ht = hs.create(h);
		return ResponseEntity.status(HttpStatus.CREATED).body(ht);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll (){
		return ResponseEntity.ok(hs.getAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Hotel> getOne (@PathVariable("id") String id){
		return ResponseEntity.ok(hs.getOne(id));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> deleteOne (@PathVariable("id") String id) {
		String deleteOne = hs.deleteOne(id);
		return ResponseEntity.ok(deleteOne);
	}

}
