package com.ahmad.hospitalSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name= "patient")
@NoArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long id;
	
	@Column(name="first_name", nullable=false)
	@Getter @Setter
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender", nullable=false)
	private Gender gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="next_of_kin")
	private String nextOfKin;
	
	@Column(name="next_of_kin_address")
	private String nextOfKinAddress;
	
	@OneToOne(mappedBy="patient", cascade=CascadeType.REMOVE)
	private PatientPersonalDetails personalDetail;
	
	@OneToMany(mappedBy="patientDetails")
	private List<PatientRecord> records;

	public Patient(String firstName, String lastName, Gender gender, String address, String nextOfKin,
			String nextOfKinAddress, PatientPersonalDetails personalDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.nextOfKin = nextOfKin;
		this.nextOfKinAddress = nextOfKinAddress;
		this.personalDetail = personalDetail;
	}

	
}
