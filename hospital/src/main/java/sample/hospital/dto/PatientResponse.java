package sample.hospital.dto;

import sample.hospital.model.Patient;

public class PatientResponse {

	private Long id;
	private String name;
	private String surname;
	
	
	public PatientResponse(Patient patient) {
		this.id = patient.getId();
		this.name = patient.getName();
		this.surname = patient.getSurname();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
