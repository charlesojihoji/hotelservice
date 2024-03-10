package com.softel.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "micro_hotel")
public class Hotel {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Location")
	private String location;

	@Column(name = "About")
	private String about;

	public Hotel() {
		super();
	}

	public Hotel(String id, String name, String location, String about) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", about=" + about + "]";
	}

}
