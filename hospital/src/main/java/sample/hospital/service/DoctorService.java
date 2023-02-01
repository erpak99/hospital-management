package sample.hospital.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sample.hospital.dto.DoctorCreateRequest;
import sample.hospital.dto.DoctorResponse;
import sample.hospital.exception.NotFoundException;
import sample.hospital.model.Department;
import sample.hospital.model.Doctor;
import sample.hospital.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private final DoctorRepository doctorRepository;
	private final DepartmentService departmentService;
	private final PasswordEncoder passwordEncoder;
														
	public DoctorService(DoctorRepository doctorRepository, DepartmentService departmentService) {
		super();
		this.doctorRepository = doctorRepository;
		this.departmentService = departmentService;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public Doctor createDoctor(DoctorCreateRequest doctorCreateRequest) throws NotFoundException {
		Department department = departmentService.findById(doctorCreateRequest.getDepartmentId());
		if(department == null) {
			throw new NotFoundException(
					"Department with id " +doctorCreateRequest.getDepartmentId()+" not found");
			}
		Doctor newDoctor = new Doctor();
		newDoctor.setId(doctorCreateRequest.getId());
		newDoctor.setName(doctorCreateRequest.getName());
		newDoctor.setSurname(doctorCreateRequest.getSurname());
		String identityNumber = doctorCreateRequest.getIdentityNumber();
		String maskedIdentityNumber = identityNumber.substring(0, 3) + "********";
		newDoctor.setIdentityNumber(maskedIdentityNumber);
		String encodedPassword = passwordEncoder.encode(doctorCreateRequest.getPassword());
		newDoctor.setPassword(encodedPassword);
		newDoctor.setDepartment(department);
		
		return doctorRepository.save(newDoctor);
	}

	public List<DoctorResponse> getAllDoctors(Optional<Long> departmentId) {
		List<Doctor> list;
		if(departmentId.isPresent()) {
			list = doctorRepository.findByDepartment_Id(departmentId.get());
		}
		else
			list = doctorRepository.findAll();
		return list.stream().map(doctor -> new DoctorResponse(doctor)).collect(Collectors.toList());
	}

	public DoctorResponse findById(Long id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Doctor with id "+id+" not found"));
		return new DoctorResponse(doctor);
	}

	public List<DoctorResponse> findByDepartmentName(String name) {
		List<Doctor> doctors = doctorRepository.findByDepartment_Name(name);
		return doctors.stream().map(doctor -> new DoctorResponse(doctor)).collect(Collectors.toList());
	}
	
	public void deleteById(Long id) {
		doctorRepository.deleteById(id);
	}
	
	public Doctor findByIdForAppointment(Long id) {
		return doctorRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Doctor with id "+id+" not found"));
	}
}
