package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientRespository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByUserNameAndPassword(String userName, String password);
}