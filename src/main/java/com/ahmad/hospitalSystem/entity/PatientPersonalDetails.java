package com.ahmad.hospitalSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="personal_detail")
@Getter @Setter @NoArgsConstructor
public class PatientPersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="genotype")
	private String genoType;
	
	@OneToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public PatientPersonalDetails(double weight, String bloodGroup, String genoType) {
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.genoType = genoType;
	}
	
	
}
