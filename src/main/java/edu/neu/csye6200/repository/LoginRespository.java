package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.entity.Staff;

import java.util.Optional;

public interface LoginRespository {

    Optional<Patient> findPatientByUsernameAndPassword(String username, String password);
    Optional<Staff> findStaffByUsernameAndPassword(String username, String password);
}