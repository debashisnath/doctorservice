package com.lifeguard.doctorservice.service;

import java.util.List;

import com.lifeguard.doctorservice.exception.DoctorServiceDetailsExistsException;
import com.lifeguard.doctorservice.exception.DoctorServiceDetailsNotFoundException;
import com.lifeguard.doctorservice.exception.UpdateFailedException;
import com.lifeguard.doctorservice.model.DoctorServiceDetails;

public interface DoctorService {

	public DoctorServiceDetails saveDoctorServiceDetails(DoctorServiceDetails doctorServiceDetails) throws DoctorServiceDetailsExistsException;
	
	public List<DoctorServiceDetails> getDoctorServiceDetailsList(String city) throws DoctorServiceDetailsNotFoundException;
	
	public DoctorServiceDetails getDoctorServiceDetails(String govtRegNo) throws DoctorServiceDetailsNotFoundException;
	
	public DoctorServiceDetails updateDoctorServiceDetails(DoctorServiceDetails doctorServiceDetails) throws UpdateFailedException;
	
}
