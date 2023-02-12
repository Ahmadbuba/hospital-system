package com.ahmad.hospitalSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="doctor")
@Getter @Setter @NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long doctorId;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="gender", nullable=false)
	private Gender gender;
	
	@Column(name="department")
	private String department;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="next_of_kin", nullable=false)
	private String nextOfKin;
	
	@Column(name="next_of_kin_address", nullable=false)
	private String nextOfKinAddress;
	
	
	@OneToMany(mappedBy="doctorDetails")
	@JsonIgnore
	private List<PatientRecord> patientRecords;
}
