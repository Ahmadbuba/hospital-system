package com.ahmad.hospitalSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmad.hospitalSystem.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByPatientRecordId(long recordId);
	
	Patient findByPatientPersonalDetailsId(long patientPersonalDetailsId);
	
	List<Patient> findByFirstNameContaining(String firstName);
}
