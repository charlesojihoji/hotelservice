package com.softel.hotel.service;

import java.util.List;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.response.HotelServiceResponse;

public interface HotelService {

	public Hotel create(Hotel hotel);
	
	public Hotel update(Hotel hotel, String id);
	
	public List<HotelServiceResponse> getAll();
	
	public HotelServiceResponse get(String id);
	
	public String delete(String id);
}
