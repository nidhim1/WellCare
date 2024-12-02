package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.entity.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface LoginRespository {

//    @Query("SELECT p FROM Patient p WHERE p.userName = ?1 AND p.password = ?")
    Optional<Patient> findPatientByUsernameAndPassword(String username, String password);


//    @Query("SELECT s FROM Staff s WHERE s.userName = ?1 AND s.password = ?")
    Optional<Staff> findStaffByUsernameAndPassword(String username, String password);
}