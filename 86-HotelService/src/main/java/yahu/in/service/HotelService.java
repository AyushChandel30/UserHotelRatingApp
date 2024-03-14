package yahu.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import yahu.in.entity.Hotel;

@Service
public interface HotelService {
	
	public Hotel create (Hotel hot);
	public List<Hotel> getAll();
	public Hotel getOne (String id);
	public String deleteOne (String id);

}
