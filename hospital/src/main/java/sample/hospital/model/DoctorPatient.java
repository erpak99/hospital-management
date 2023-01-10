package sample.hospital.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DoctorPatient implements Serializable {
  
	@Column(name = "doctor_id")
	private Long doctorId;
  
	@Column(name = "patient_id")
	private Long patientId;

	public DoctorPatient() {
		
	}
	
	public DoctorPatient(Long doctorId, Long patientId) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
	}


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public Long getPatientId() {
		return patientId;
	}


	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

}