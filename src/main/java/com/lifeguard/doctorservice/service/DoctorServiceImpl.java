package com.lifeguard.doctorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeguard.doctorservice.exception.DoctorServiceDetailsExistsException;
import com.lifeguard.doctorservice.exception.DoctorServiceDetailsNotFoundException;
import com.lifeguard.doctorservice.exception.UpdateFailedException;
import com.lifeguard.doctorservice.model.DoctorServiceDetails;
import com.lifeguard.doctorservice.repository.DoctorServiceRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	public DoctorServiceRepository doctorServiceRepo;
	public DoctorServiceDetails doctorServiceDetails = null;
	public List<DoctorServiceDetails> doctorServiceDetailsList = null;
	
	@Autowired
	public DoctorServiceImpl(DoctorServiceRepository doRepository) {
	this.doctorServiceRepo = doRepository;
	}
	@Override
	public DoctorServiceDetails saveDoctorServiceDetails(DoctorServiceDetails doctorServiceDetails)
			throws DoctorServiceDetailsExistsException {
		if(doctorServiceRepo.findByDoctorProfileGovtRegNo(doctorServiceDetails.getDoctorProfile().getGovtRegNo()) == null) {
			doctorServiceDetails = doctorServiceRepo.save(doctorServiceDetails);
			return doctorServiceDetails;
		}
		else
		throw new DoctorServiceDetailsExistsException("Details Already exists");
	}
	@Override
	public List<DoctorServiceDetails> getDoctorServiceDetailsList(String city)
			throws DoctorServiceDetailsNotFoundException {
		if(doctorServiceRepo.findByDoctorProfileCity(city)!=null) {
			doctorServiceDetailsList = doctorServiceRepo.findByDoctorProfileCity(city);
			return doctorServiceDetailsList;
		}
		else
		throw new DoctorServiceDetailsNotFoundException("Doctor Service Details not found");
	}
	@Override
	public DoctorServiceDetails getDoctorServiceDetails(String govtRegNo) throws DoctorServiceDetailsNotFoundException {
		if(doctorServiceRepo.findByDoctorProfileGovtRegNo(govtRegNo)!=null) {
			doctorServiceDetails = doctorServiceRepo.findByDoctorProfileGovtRegNo(govtRegNo);
			return doctorServiceDetails;
		}
		else
			throw new DoctorServiceDetailsNotFoundException("Doctor service details not found");
	}
	@Override
	public DoctorServiceDetails updateDoctorServiceDetails(DoctorServiceDetails dServiceDetails)
			throws UpdateFailedException {
		if(doctorServiceRepo.findByDoctorProfileGovtRegNo(dServiceDetails.getDoctorProfile().getGovtRegNo())!=null) {
			doctorServiceDetails = doctorServiceRepo.findByDoctorProfileGovtRegNo(dServiceDetails.getDoctorProfile().getGovtRegNo());
			doctorServiceRepo.delete(doctorServiceDetails);
			DoctorServiceDetails serviceDetails = doctorServiceRepo.save(dServiceDetails);
			return serviceDetails;
		}
		else
			throw new UpdateFailedException("Doctor service details update failed");
	}

	

}
