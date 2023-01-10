package sample.hospital.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.hospital.dto.AppointmentCreateRequest;
import sample.hospital.dto.AppointmentResponse;
import sample.hospital.model.Appointment;
import sample.hospital.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentCreateRequest appointmentCreateRequest) {
		return ResponseEntity.ok(appointmentService.createAppointment(appointmentCreateRequest));
	}
	
	@GetMapping("getall")
	public List<AppointmentResponse> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}
	
	@GetMapping("/{id}")
	public AppointmentResponse findById(@PathVariable Long id) {
		return appointmentService.findById(id);
	}
	
}
