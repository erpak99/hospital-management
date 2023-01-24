package sample.hospital.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class AppointmentCreateRequest {

	private Long id;
	
	@NotNull(message = "Patient id can not be empty")
	private Long patientId;
	
	@NotNull(message = "Doctor id can not be empty")
	private Long doctorId;
	
	@NotNull(message = "Department id can not be empty")
	private Long departmentId;

	@NotNull(message = "Date can not be empty")
	private LocalDateTime date;

	public AppointmentCreateRequest(Long id, Long patientId, Long doctorId, Long departmentId,LocalDateTime date) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.departmentId = departmentId;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
