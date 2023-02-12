package com.ahmad.hospitalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmad.hospitalSystem.entity.PatientPersonalDetails;

public interface PatientPersonalDetailsRepository extends JpaRepository<PatientPersonalDetails, Long> {

	PatientPersonalDetails findByPatientId(long patientId);
}
