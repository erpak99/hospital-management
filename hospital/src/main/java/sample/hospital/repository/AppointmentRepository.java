package sample.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.hospital.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByPatient_Id(Long id);
	
}
