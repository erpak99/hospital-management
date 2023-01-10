package sample.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sample.hospital.dto.AppointmentPatientResponse;
import sample.hospital.dto.PatientCreateRequest;
import sample.hospital.dto.PatientResponse;
import sample.hospital.exception.NotFoundException;
import sample.hospital.model.Appointment;
import sample.hospital.model.Patient;
import sample.hospital.repository.PatientRepository;

@Service
public class PatientService {

	private final PatientRepository patientRepository;
	private final PasswordEncoder passwordEncoder;
	private final AppointmentService appointmentService;
	
	@Lazy
	public PatientService(PatientRepository patientRepository, AppointmentService appointmentService) {
		this.patientRepository = patientRepository;
		this.passwordEncoder  = new BCryptPasswordEncoder();
		this.appointmentService = appointmentService;
	}

	public Patient createPatient(PatientCreateRequest patientCreateRequest) {
		Patient newPatient = new Patient();
		
		newPatient.setId(patientCreateRequest.getId());
		newPatient.setName(patientCreateRequest.getName());
		newPatient.setSurname(patientCreateRequest.getSurname());
		String identityNumber = patientCreateRequest.getIdentityNumber();
		String maskedIdentityNumber = identityNumber.subSequence(0, 3) + "********";
		newPatient.setIdentityNumber(maskedIdentityNumber);
		String encodedPassword = passwordEncoder.encode(patientCreateRequest.getPassword());
		newPatient.setPassword(encodedPassword);
	
		return patientRepository.save(newPatient);
	}

	public List<PatientResponse> getAllPatients() {
		List<Patient> list;
		list = patientRepository.findAll();
		return list.stream().map(patient -> new PatientResponse(patient)).collect(Collectors.toList());
	}

	public AppointmentPatientResponse findById(Long id) {
		Patient patient = patientRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Patient with id "+id+" not found"));
		List<Appointment> appointments = appointmentService.findByPatientId(id);
		return new AppointmentPatientResponse(patient,appointments); 
	}

	public void deleteById(Long id) {
		patientRepository.deleteById(id);
	}
												
	public Patient findByIdForAppointment(Long id) {
		return patientRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Patient with id "+id+" not found"));
	}
	
}
