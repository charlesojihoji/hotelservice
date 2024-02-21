package com.softel.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {

		hotel.setId(UUID.randomUUID().toString());
		
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel update(Hotel hotel, String id) {

		Hotel theHotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the hotel"));
		
		theHotel.setName(hotel.getName());
		theHotel.setLocation(hotel.getLocation());
		theHotel.setAbout(hotel.getAbout());
		
		return theHotel;
	}

	@Override
	public List<Hotel> getAll() {

		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {

		return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the hotel"));
	}

	@Override
	public String delete(String id) {
		
		hotelRepository.deleteById(id);
		
		return "The Hotel with ID " + id + " has been successfully deleted.";
	}

}
