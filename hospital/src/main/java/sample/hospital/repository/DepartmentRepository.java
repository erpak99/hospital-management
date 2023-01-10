package sample.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.hospital.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
