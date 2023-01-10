package sample.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
