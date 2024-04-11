package com.olah.cinema.persistence.entity;

import java.util.ArrayList;
import lombok.Builder;

@Builder
public class Cinema extends Entity{
	private int cinemaId;
	private String name;
	private String address;
	private String city;

	public Cinema(int cinemaId, String name, String address, String city) {
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.validationMessages = new ArrayList<>();
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Cinema{" +
		    "cinemaId=" + cinemaId +
		    ", name='" + name + '\'' +
		    ", address='" + address + '\'' +
		    ", city='" + city + '\'' +
		    '}';
	}
}
