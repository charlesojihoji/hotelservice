package com.softel.hotel.controllers;

import java.util.List;

import com.softel.hotel.response.HotelServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softel.hotel.entity.Hotel;
import com.softel.hotel.service.HotelService;

@RestController
@RefreshScope
@RequestMapping("/hotel")
public class HotelController {

	private Logger logger = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;
	
	@Value("${message:Hello default}")
	private String message;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {

		logger.info("Create a Single Hotel Handler: HotelController " + hotel);

		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}

	@GetMapping
	public ResponseEntity<List<HotelServiceResponse>> getAllHotels() {

		logger.info("Get a List of Hotels Handler: HotelController ");

		List<HotelServiceResponse> hotelServiceResponse = hotelService.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(hotelServiceResponse);
	}
	@GetMapping("/location/{place}")
	public ResponseEntity<List<HotelServiceResponse>> getListOfHotelsBasedOnLocation(@PathVariable String place) {

		logger.info("Get a List of Hotels Handler: HotelController ");

		List<HotelServiceResponse> hotelServiceResponse = hotelService.getListOfHotelsBasedOnLocation(place);

		return ResponseEntity.status(HttpStatus.OK).body(hotelServiceResponse);
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<List<HotelServiceResponse>> getListOfHotelsByName(@PathVariable String name) {

		logger.info("Get a List of Hotels Handler: HotelController ");

		List<HotelServiceResponse> hotelServiceResponse = hotelService.getListOfHotelsByName(name);

		return ResponseEntity.status(HttpStatus.OK).body(hotelServiceResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HotelServiceResponse> getHotel(@PathVariable String id) {

		logger.info("Get a Single Hotel Handler: HotelController " + id);

		HotelServiceResponse hotelServiceResponse = hotelService.get(id);

		return ResponseEntity.status(HttpStatus.OK).body(hotelServiceResponse);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String id) {

		logger.info("Update a Single Hotel Handler: HotelController " + hotel + ", " + id);

		return ResponseEntity.status(HttpStatus.OK).body(hotelService.update(hotel, id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable String id) {

		logger.info("Delete a Single Hotel Handler: HotelController " + id);

		return ResponseEntity.status(HttpStatus.OK).body(hotelService.delete(id));
	}
	
	@GetMapping("/message")
    String getMessage() {
        return this.message;
    }
}
