package sample.hospital.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import sample.hospital.dto.AppointmentCreateRequest;
import sample.hospital.dto.AppointmentResponse;
import sample.hospital.dto.AppointmentUpdateRequest;
import sample.hospital.exception.NotFoundException;
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
	public ResponseEntity<Appointment> createAppointment(@RequestBody @Valid AppointmentCreateRequest appointmentCreateRequest) throws NotFoundException, MessagingException {
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
	
	@PutMapping("/{id}")
	public AppointmentResponse updateAppointment(@PathVariable Long id,
												 @RequestBody @ Valid
												 AppointmentUpdateRequest appointmentUpdateRequest) {
		return appointmentService.updateAppointment(id,appointmentUpdateRequest);
	}
	
	@GetMapping("/findbydate")
	public List<AppointmentResponse> findByDate(@RequestParam LocalDateTime date) {
		return appointmentService.findByDate(date);
	}
	
	@GetMapping("/findbydatebetween")
	public List<AppointmentResponse> findByDateBetween(@RequestParam LocalDateTime start,
													   @RequestParam LocalDateTime end) {
		return appointmentService.findByDateBetween(start,end);
	}
	
	@GetMapping("/findbypatientidanddepartmentname")
	public List<AppointmentResponse> findByPatientIdAndDepartmentName(@RequestParam Long id,
																	  @RequestParam String name) {
		return appointmentService.findByPatientIdAndDepartmentName(id, name);
	}
}
