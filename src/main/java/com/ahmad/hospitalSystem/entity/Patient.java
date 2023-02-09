package com.ahmad.hospitalSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name= "patient")
@Getter @Setter @NoArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long patientId;
	
	@Column(name="first_name", nullable=false)
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
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="personal_detail_id")
	private PatientPersonalDetails personalDetail;
	
	@OneToMany(mappedBy="patientDetails")
	private List<PatientRecord> notes;

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
