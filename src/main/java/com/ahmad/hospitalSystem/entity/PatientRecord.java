package com.ahmad.hospitalSystem.entity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name="patient_record")
@Getter @Setter @NoArgsConstructor
public class PatientRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="record_id")
	private long id;
	
	@Column(name="date", nullable=false)
	private OffsetDateTime time;
	
	@Column(name="note", nullable=false)
	private String note;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="patient_id", nullable=false)
	@JsonIgnore
	private Patient patientDetail;
	
	@OneToMany
	@JoinColumn(name="doctor_id", nullable=false)
	@JsonIgnore
	private List<Doctor> doctorDetails;
	
}
