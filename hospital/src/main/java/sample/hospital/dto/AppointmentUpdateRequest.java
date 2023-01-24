package sample.hospital.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class AppointmentUpdateRequest {

	@NotNull(message = "Doctor id can not be empty")
	private Long doctorId;
	
	@NotNull(message = "Date can not be empty")
	private LocalDateTime date;

	public AppointmentUpdateRequest(Long doctorId, LocalDateTime date) {
		super();
		this.doctorId = doctorId;
		this.date = date;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
