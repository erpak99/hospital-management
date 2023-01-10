package sample.hospital.dto;

import java.util.List;

import sample.hospital.model.Appointment;
import sample.hospital.model.Patient;

public class AppointmentPatientResponse {

	private Long id;
	private String name;
	private String surname;
	private List<Appointment> appointments;
							
	public AppointmentPatientResponse(Patient patient, List<Appointment> appointments) {
		this.id = patient.getId();
		this.name = patient.getName();
		this.surname = patient.getSurname();
		this.appointments = patient.getAppointments();
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
