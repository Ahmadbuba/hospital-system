package com.ahmad.hospitalSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name="personal_detail")
@Getter @Setter
public class PatientPersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="detail_id")
	private Long id;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="genotype")
	private String genoType;
	
	@OneToOne(mappedBy="personalDetail", cascade=CascadeType.ALL)
	private Patient patient;

	public PatientPersonalDetails(double weight, String bloodGroup, String genoType) {
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.genoType = genoType;
	}
	
	
}
