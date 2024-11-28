package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInfoRepository extends JpaRepository<Patient, Integer> {
    // Custom add operation
    default void addPatient(Patient patient) {
        save(patient); // JpaRepository's built-in save() method
    }
}
