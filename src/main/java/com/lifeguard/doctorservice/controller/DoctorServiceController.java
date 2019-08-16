package com.lifeguard.doctorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifeguard.doctorservice.exception.DoctorServiceDetailsExistsException;
import com.lifeguard.doctorservice.exception.DoctorServiceDetailsNotFoundException;
import com.lifeguard.doctorservice.exception.UpdateFailedException;
import com.lifeguard.doctorservice.model.DoctorServiceDetails;
import com.lifeguard.doctorservice.service.DoctorService;

@CrossOrigin(origins="*")
@RestController
public class DoctorServiceController {

	public DoctorService doctorService;
	
	@Autowired
	public DoctorServiceController(DoctorService dservice) {
		this.doctorService = dservice;
	}
	
	@PostMapping("api/doctordetails")
	public ResponseEntity<?> saveDoctorDetails(@RequestBody DoctorServiceDetails doctorServiceDetails) throws
	DoctorServiceDetailsExistsException{
		try {
			DoctorServiceDetails dServiceDetails = doctorService.saveDoctorServiceDetails(doctorServiceDetails);
			return new ResponseEntity<DoctorServiceDetails>(dServiceDetails, HttpStatus.OK);
		}
		catch(DoctorServiceDetailsExistsException e) {
			return new ResponseEntity<String>("Details Already Exists", HttpStatus.CONFLICT);
		}
	}
	
	//@GetMapping("api/doctordetails/{city}")
	@RequestMapping(value = "api/doctordetails/{city}", method = RequestMethod.GET)
	public ResponseEntity<?> getDoctorDetailsList(@PathVariable("city") String city) throws DoctorServiceDetailsNotFoundException{
		try {
			List<DoctorServiceDetails> doctorServiceDetails = doctorService.getDoctorServiceDetailsList(city);
			return new ResponseEntity<List<DoctorServiceDetails>>(doctorServiceDetails, HttpStatus.OK);
		}
		catch(DoctorServiceDetailsNotFoundException e) {
			return new ResponseEntity<String>("Details not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("api/doctordetail/{govtRegNo}")
	public ResponseEntity<?> getDoctorDetails(@PathVariable String govtRegNo) throws DoctorServiceDetailsNotFoundException{
		try {
			DoctorServiceDetails doctorServiceDetails = doctorService.getDoctorServiceDetails(govtRegNo);
			return new ResponseEntity<DoctorServiceDetails>(doctorServiceDetails, HttpStatus.OK);
		}
		catch(DoctorServiceDetailsNotFoundException e) {
			return new ResponseEntity<String>("Details not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("api/doctordetails")
	public ResponseEntity<?> updateDoctorDetails(@RequestBody DoctorServiceDetails doctorServiceDetails) throws UpdateFailedException{
		try {
			DoctorServiceDetails dServiceDetails=doctorService.updateDoctorServiceDetails(doctorServiceDetails);
			return new ResponseEntity<DoctorServiceDetails>(dServiceDetails, HttpStatus.OK);
		}
		catch(UpdateFailedException e) {
			return new ResponseEntity<String>("Update failed", HttpStatus.EXPECTATION_FAILED);
		}
	}
}
