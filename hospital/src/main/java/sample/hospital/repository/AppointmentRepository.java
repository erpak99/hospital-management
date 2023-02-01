package sample.hospital.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.hospital.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByPatient_Id(Long id);

	List<Appointment> findByDate(LocalDateTime date);

	List<Appointment> findByDateBetween(LocalDateTime start, LocalDateTime end);

	List<Appointment> findByPatient_IdAndDepartment_Name(Long id, String name);
	
}
