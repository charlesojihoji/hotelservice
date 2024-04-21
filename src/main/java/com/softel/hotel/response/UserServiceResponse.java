package com.softel.hotel.response;

public class UserServiceResponse {

    private String id;
    private String name;
    private String emailId;
    private String about;

    public UserServiceResponse() {
    }

    public UserServiceResponse(String id, String name, String emailId, String about) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.about = about;
    }

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
