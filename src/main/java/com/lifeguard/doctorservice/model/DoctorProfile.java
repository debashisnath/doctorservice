package com.lifeguard.doctorservice.model;

public class DoctorProfile {

	private String doctorName;
	private String phoneNumber;
	private String emailId;
	private String hospitalName;
	private String govtRegNo;
	private String city;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getGovtRegNo() {
		return govtRegNo;
	}

	public void setGovtRegNo(String govtRegNo) {
		this.govtRegNo = govtRegNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DoctorProfile(String doctorName, String phoneNumber, String emailId, String hospitalName, String govtRegNo,
			String city) {
		super();
		this.doctorName = doctorName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.hospitalName = hospitalName;
		this.govtRegNo = govtRegNo;
		this.city = city;
	}

	public DoctorProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

}
