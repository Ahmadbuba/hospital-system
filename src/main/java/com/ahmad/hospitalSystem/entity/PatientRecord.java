package com.ahmad.hospitalSystem.entity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity( name="patient_record")
public class PatientRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long id;
	
	@Column(name="date")
	private OffsetDateTime time;
	
	@Column(name="note")
	private String note;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patientDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="doctor_id")
	private Doctor doctorDetails;
	
}
