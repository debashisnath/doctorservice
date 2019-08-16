package com.lifeguard.doctorservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lifeguard.doctorservice.model.DoctorServiceDetails;

@Repository
public interface DoctorServiceRepository extends MongoRepository<DoctorServiceDetails, Integer> {
	
	public List<DoctorServiceDetails> findByDoctorProfileCity(String city);
	
	public DoctorServiceDetails findByDoctorProfileGovtRegNo(String govtRegNo);

}
