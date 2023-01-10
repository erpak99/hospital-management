package sample.hospital.dto;

import sample.hospital.model.Doctor;

public class DoctorResponse {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String departmentName;
	
	public DoctorResponse(Doctor doctor) {
		this.id = doctor.getId();
		this.name = doctor.getName();
		this.surname = doctor.getSurname();
		this.departmentName = doctor.getDepartment().getName();
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
