package com.softel.hotel.service;

import java.util.List;

import com.softel.hotel.entity.Hotel;

public interface HotelService {

	public Hotel create(Hotel hotel);
	
	public Hotel update(Hotel hotel, String id);
	
	public List<Hotel> getAll();
	
	public Hotel get(String id);
	
	public String delete(String id);
}
