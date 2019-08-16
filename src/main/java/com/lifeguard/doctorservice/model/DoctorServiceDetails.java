package com.lifeguard.doctorservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class DoctorServiceDetails {
	@Id
	public String id;
	public DoctorProfile doctorProfile;
	public String specialistIn;
	public String address;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public String availabilityUpto;
	public String degree;
	public String message;

	public DoctorProfile getDoctorProfile() {
		return doctorProfile;
	}

	public void setDoctorProfile(DoctorProfile doctorProfile) {
		this.doctorProfile = doctorProfile;
	}

	public String getSpecialistIn() {
		return specialistIn;
	}

	public void setSpecialistIn(String specialistIn) {
		this.specialistIn = specialistIn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvailabilityUpto() {
		return availabilityUpto;
	}

	public void setAvailabilityUpto(String availabilityUpto) {
		this.availabilityUpto = availabilityUpto;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DoctorServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorServiceDetails(DoctorProfile doctorProfile, String specialistIn, String address,
			String availabilityUpto, String degree, String message, String id) {
		super();
		this.id = id;
		this.doctorProfile = doctorProfile;
		this.specialistIn = specialistIn;
		this.address = address;
		this.availabilityUpto = availabilityUpto;
		this.degree = degree;
		this.message = message;
	}

}
