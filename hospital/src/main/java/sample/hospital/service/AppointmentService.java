package sample.hospital.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import sample.hospital.dto.AppointmentCreateRequest;
import sample.hospital.dto.AppointmentResponse;
import sample.hospital.dto.AppointmentUpdateRequest;
import sample.hospital.exception.NotFoundException;
import sample.hospital.model.Appointment;
import sample.hospital.model.Department;
import sample.hospital.model.Doctor;
import sample.hospital.model.Patient;
import sample.hospital.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;
	private final PatientService patientService;
	private final DoctorService doctorService;
	private final DepartmentService departmentService;
																											
	public AppointmentService(AppointmentRepository appointmentRepository,
							  PatientService patientService,
							  DoctorService doctorService,
							  DepartmentService departmentService) {
		this.appointmentRepository = appointmentRepository;
		this.patientService = patientService;
		this.doctorService = doctorService;
		this.departmentService = departmentService;
	}

	public Appointment createAppointment(AppointmentCreateRequest appointmentCreateRequest)
										 throws NotFoundException {
		Patient patient = patientService.findByIdForAppointment(appointmentCreateRequest.getPatientId());
		Doctor doctor = doctorService.findByIdForAppointment(appointmentCreateRequest.getDoctorId());
		Department department = departmentService.findById(appointmentCreateRequest.getDepartmentId());
		if((patient != null && doctor != null && department != null)
			&& doctor.getDepartment().getId() == department.getId()) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId(appointmentCreateRequest.getId());
			newAppointment.setPatient(patient);
			newAppointment.setDoctor(doctor);
			newAppointment.setDepartment(department);
			newAppointment.setDate(appointmentCreateRequest.getDate());
			return appointmentRepository.save(newAppointment);
		}
		else throw new NotFoundException("Please check patient, doctor and departmend info...");
	}

	public List<AppointmentResponse> getAllAppointments() {
		List<Appointment> list;
		list = appointmentRepository.findAll();
		return list.stream().
				map(appointment -> new AppointmentResponse(appointment)).
				collect(Collectors.toList());
	}

	public AppointmentResponse findById(Long id) {
		Appointment appointment = appointmentRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Appointment with id "+id+" not found"));
		return new AppointmentResponse(appointment);
	}

	public List<Appointment> findByPatientId(Long id) {
		return appointmentRepository.findByPatient_Id(id);
	}

	public AppointmentResponse updateAppointment(Long id, AppointmentUpdateRequest appointmentUpdateRequest)
												 throws NotFoundException {
		Optional<Appointment> appointment = Optional.of(appointmentRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Appointment with id "+id+" not found")));
		Doctor doctor = doctorService.findByIdForAppointment(appointmentUpdateRequest.getDoctorId());
		if(appointment.isPresent() && doctor !=null &&
		   doctor.getDepartment().getId() == appointment.get().getDepartment().getId() ) {
			Appointment updatedAppointment = appointment.get();
			updatedAppointment.setDate(appointmentUpdateRequest.getDate());
			updatedAppointment.setDoctor(doctor);
			appointmentRepository.save(updatedAppointment);
			return new AppointmentResponse(updatedAppointment);
		}
		else throw new NotFoundException("Check doctor's department id carefully...");
	}
	
}
