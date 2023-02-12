package com.ahmad.hospitalSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmad.hospitalSystem.entity.PatientRecord;

public interface PatientRecordRespository extends JpaRepository<PatientRecord, Long> {

	List<PatientRecord> findByPatientId(long patientId);
	
	List<PatientRecord> findByDoctorId(long doctorId);
}
