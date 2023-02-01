package sample.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sample.hospital.dto.DoctorCreateRequest;
import sample.hospital.dto.DoctorResponse;
import sample.hospital.model.Doctor;
import sample.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private final DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@PostMapping("/create")
	public ResponseEntity<Doctor> createDoctor(@RequestBody @Valid DoctorCreateRequest doctorCreateRequest) {
		return ResponseEntity.ok(doctorService.createDoctor(doctorCreateRequest));
	}
	
	@GetMapping
	public List<DoctorResponse> getAllDoctors(@RequestParam Optional<Long> departmentId) {
		return doctorService.getAllDoctors(departmentId);
	}
	
	@GetMapping("/{id}")
	public DoctorResponse findById(@PathVariable Long id) {
		return doctorService.findById(id);
	}
	
	@GetMapping("/findbydepartmentname")
	public List<DoctorResponse> findByDepartmentName(@RequestParam String name) {
		return doctorService.findByDepartmentName(name);
	}
	
	@DeleteMapping("/{id}")
	public void deletebyId(@PathVariable Long id) {
		doctorService.deleteById(id);
	}
}
