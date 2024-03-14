package yahu.in.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yahu.in.entity.Hotel;
import yahu.in.exception.ResourceNotFoundException;
import yahu.in.repo.HotelRepository;

@Service
public class HotelServiceImp implements HotelService {
	
	private HotelRepository hr;
	
	@Autowired
	public HotelServiceImp (HotelRepository hr) {
		this.hr=hr;
	}

	@Override
	public Hotel create(Hotel hot) {
		String string = UUID.randomUUID().toString();
		hot.setId(string);
		return hr.save(hot);
	}

	@Override
	public List<Hotel> getAll() {
		return hr.findAll();
	}

	@Override
	public Hotel getOne(String id) {
		Hotel hotel = hr.findById(id)
							.orElseThrow(
								()->new ResourceNotFoundException
									("Hotel with given id not found"));
		return hotel;
	}

	@Override
	public String deleteOne(String id) {
		hr.deleteById(id);
		return "Hotel Deleted";
	}

}
