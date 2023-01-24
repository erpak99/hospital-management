package sample.hospital.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sample.hospital.dto.AppointmentPatientResponse;
import sample.hospital.dto.PatientCreateRequest;
import sample.hospital.dto.PatientResponse;
import sample.hospital.model.Patient;
import sample.hospital.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Patient> createPatient(@RequestBody @Valid PatientCreateRequest patientCreateRequest) {
		return ResponseEntity.ok(patientService.createPatient(patientCreateRequest));
	}
	
	@GetMapping("/getall")
	public List<PatientResponse> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	@GetMapping("/{id}")
	public AppointmentPatientResponse findById(@PathVariable Long id) {
		return patientService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		patientService.deleteById(id);
	}
}
