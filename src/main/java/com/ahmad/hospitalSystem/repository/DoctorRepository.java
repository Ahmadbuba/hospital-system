package com.ahmad.hospitalSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmad.hospitalSystem.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	List<Doctor> findByPatientRecordId(long patientRecordId);

}
