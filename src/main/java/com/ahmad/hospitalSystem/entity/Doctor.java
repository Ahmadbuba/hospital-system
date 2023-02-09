package com.ahmad.hospitalSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private long doctorId;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender", nullable=false)
	private Gender gender;
	
	@Column(name="department")
	private String department;
	
	@Column(name="address")
	private String address;
	
	@Column(name="next_of_kin")
	private String nextOfKin;
	
	@Column(name="next_of_kin_address")
	private String nextOfKinAddress;
	
	@OneToMany(mappedBy="doctor")
	private List<PatientRecord> patientRecords;
}
