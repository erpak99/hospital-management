package sample.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sample.hospital.exception.NotFoundException;
import sample.hospital.model.Department;
import sample.hospital.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department findById(Long id) {
		return departmentRepository.findById(id).orElseThrow(
							() -> new NotFoundException("Department with id " +id+ " not found")
				); 
	}


	
}
