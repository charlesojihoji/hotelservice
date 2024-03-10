package com.softel.hotel.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	private Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {

		hotel.setId(UUID.randomUUID().toString());

		Hotel newHotel = null;

		try {
			newHotel = hotelRepository.save(hotel);
		} catch (Exception e) {

			logger.error("An Error Occurred While Creating Hotel:HotelUserServiceImpl. Exception message is: "
					+ e.getMessage());

			e.printStackTrace();
		}
		return newHotel;
	}

	@Override
	public Hotel update(Hotel hotel, String id) {

		Hotel refHotel = null;

		logger.info("Update a Single Hotel Handler: HotelServiceImpl " + hotel + ", " + id);

		Hotel theHotel = hotelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Could not find the hotel"));

		theHotel.setName(hotel.getName());
		theHotel.setLocation(hotel.getLocation());
		theHotel.setAbout(hotel.getAbout());

		try {
			refHotel = hotelRepository.save(theHotel);

			logger.info("Updated a Single Hotel Handler: HotelServiceImpl " + refHotel);
		} catch (Exception e) {
			logger.error("An Error Occurred While Updating Hotel:HotelUserServiceImpl. Exception message is: "
					+ e.getMessage());

			e.printStackTrace();
		}
		return refHotel;
	}

	@Override
	public List<Hotel> getAll() {

		List<Hotel> listOfHotels = null;

		try {
			logger.info("Get a List of Hotels:HotelServiceImpl");

			listOfHotels = hotelRepository.findAll();
		} catch (Exception e) {

			logger.error("An Error Occurred While Getting a List of Hotels:HotelUserServiceImpl. Exception message is: "
					+ e.getMessage());

			e.printStackTrace();
		}

		return listOfHotels;
	}

	@Override
	public Hotel get(String id) {

		logger.info("Get a Single Hotel:HotelServiceImpl " + id);

		return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the hotel"));
	}

	@Override
	public String delete(String id) {

		try {
			logger.info("Delete a Single Hotel:HotelServiceImpl " + id);
			hotelRepository.deleteById(id);
			
		} catch (Exception e) {
			logger.error("An Error Occurred While Deleting a Single Hotel:HotelUserServiceImpl. Exception message is: "
					+ e.getMessage());

			e.printStackTrace();
		}
		return "The Hotel with ID " + id + " has been successfully deleted.";
	}

}
