package sample.hospital.dto;

import java.time.LocalDateTime;

import sample.hospital.model.Appointment;

public class AppointmentResponse {

	private Long id;
	
	private String patientName;
	
	private String patientSurname;
	
	private String doctorName;
	
	private String doctorSurname;
	
	private String deparmentName;
	
	private LocalDateTime date;
	
	public AppointmentResponse(Appointment appointment) {
		this.id = appointment.getId();
		this.patientName = appointment.getPatient().getName();
		this.patientSurname = appointment.getPatient().getSurname();
		this.doctorName = appointment.getDoctor().getName();
		this.doctorSurname = appointment.getDoctor().getSurname();
		this.deparmentName = appointment.getDepartment().getName();
		this.date = appointment.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSurname() {
		return patientSurname;
	}

	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public String getDeparment() {
		return deparmentName;
	}

	public void setDeparment(String deparmentName) {
		this.deparmentName = deparmentName;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
