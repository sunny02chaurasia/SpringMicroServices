package com.zensar.model;

public class Patient {
	private String patientId;
	private String name;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient() {
		super();
	}

	public Patient(String patientId, String name) {
		super();
		this.patientId = patientId;
		this.name = name;
	}
	
}
