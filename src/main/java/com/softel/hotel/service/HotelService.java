package com.softel.hotel.service;

import java.util.List;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.response.HotelServiceResponse;

public interface HotelService {

	 Hotel create(Hotel hotel);
	
	 Hotel update(Hotel hotel, String id);
	
	 List<HotelServiceResponse> getAll();
	
	 HotelServiceResponse get(String id);
	
	 String delete(String id);
	 List<HotelServiceResponse> getListOfHotelsBasedOnLocation(String place);
	 List<HotelServiceResponse> getListOfHotelsByName(String name);

}
