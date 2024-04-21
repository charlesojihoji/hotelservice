package com.softel.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.softel.hotel.response.HotelServiceResponse;
import com.softel.hotel.response.UserServiceResponse;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.repository.HotelRepository;
import com.softel.hotel.feignclient.UserServiceClient;

@Service
public class HotelServiceImpl implements HotelService {

	private Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserServiceClient userServiceClient;

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
/*
	@Override
	public HotelServiceResponse get(String id) {

		logger.info("Get a Single Hotel:HotelServiceImpl " + id);

		return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the hotel"));
	}
*/
	@Override
	public HotelServiceResponse get(String id) {

		logger.info("Get a Single Hotel:HotelServiceImpl " + id);

		Optional<Hotel> hotel = hotelRepository.findById(id);
		HotelServiceResponse hotelServiceResponse = modelMapper.map(hotel, HotelServiceResponse.class);

		// Using FeignClient
		ResponseEntity<UserServiceResponse> userServiceResponse = userServiceClient.getUser(id);
		hotelServiceResponse.setUserServiceResponse(userServiceResponse.getBody());

		return hotelServiceResponse;

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
