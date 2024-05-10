package com.softel.hotel.response;

import java.util.List;

public class HotelServiceResponse {

    private String id;
    private String name;
    private String location;
    private String about;
    private UserServiceResponse UserServiceResponse;
    private List<UserServiceResponse> listOfUserServiceResponse;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public UserServiceResponse getUserServiceResponse() {
		return UserServiceResponse;
	}
	public void setUserServiceResponse(UserServiceResponse userServiceResponse) {
		UserServiceResponse = userServiceResponse;
	}
	public List<UserServiceResponse> getListOfUserServiceResponse() {
		return listOfUserServiceResponse;
	}
	public void setListOfUserServiceResponse(List<UserServiceResponse> listOfUserServiceResponse) {
		this.listOfUserServiceResponse = listOfUserServiceResponse;
	}

}
