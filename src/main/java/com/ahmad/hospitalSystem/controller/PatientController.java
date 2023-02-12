package com.ahmad.hospitalSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmad.hospitalSystem.entity.Patient;
import com.ahmad.hospitalSystem.exception.ResourceNotFoundException;
import com.ahmad.hospitalSystem.repository.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	PatientRepository patientRepo;
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients(@RequestParam(required = false) String firstName) {
		List<Patient> patients = new ArrayList<Patient>();
		
		if (firstName == null) 
			patientRepo.findAll().forEach(patients::add);
		else
			patientRepo.findByFirstNameContaining(firstName).forEach(patients::add);
		
		
		if(patients.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) {
		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Patient with id =" + id));
		
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient _patient = patientRepo.save(patient);
		return new ResponseEntity<>(_patient, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
		Patient _patient = patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Patient with id =" + id));
		
		return new ResponseEntity<>(patientRepo.save(_patient), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("id") long id) {
		patientRepo.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
