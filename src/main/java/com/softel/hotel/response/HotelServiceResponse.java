package com.softel.hotel.response;

public class HotelServiceResponse {

    private String id;
    private String name;
    private String location;
    private String about;
    private UserServiceResponse UserServiceResponse;

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

    public com.softel.hotel.response.UserServiceResponse getUserServiceResponse() {
        return UserServiceResponse;
    }

    public void setUserServiceResponse(com.softel.hotel.response.UserServiceResponse userServiceResponse) {
        UserServiceResponse = userServiceResponse;
    }
}
