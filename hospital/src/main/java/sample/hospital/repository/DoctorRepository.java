package sample.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.hospital.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByDepartment_Id(Long id);

	List<Doctor> findByDepartment_Name(String name);
}
