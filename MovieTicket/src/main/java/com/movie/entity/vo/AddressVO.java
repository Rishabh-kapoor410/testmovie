package com.movie.entity.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AddressVO {
	@Id
	@Column(name = "movieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String pinCode;
	private String state;
	private String streetNo;
	private String landmark;

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public String getState() {
		return state;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}
