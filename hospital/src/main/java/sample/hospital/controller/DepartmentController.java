package sample.hospital.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.hospital.model.Department;
import sample.hospital.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/create")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		return ResponseEntity.ok(departmentService.createDepartment(department));
	}
	
	@GetMapping("/getall")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		return departmentService.findById(id); 
	}
}
