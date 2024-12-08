package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.entity.Staff;
import edu.neu.csye6200.repository.LoginRespository;
import edu.neu.csye6200.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRespository loginRespository;

    @Override
    public boolean authenticatePatient(String userName, String password) {
        Optional<Patient> patient = loginRespository.findPatientByUsernameAndPassword(userName, password);
        return patient.isPresent();
    }

    @Override
    public boolean authenticateStaff(String userName, String password) {
        Optional<Staff> staff = loginRespository.findStaffByUsernameAndPassword(userName, password);
        return staff.isPresent();
    }

    @Override
    public Staff getAuthenticatedStaff(String userName, String password) {
        return loginRespository.findStaffByUsernameAndPassword(userName, password).orElse(null);
    }

    @Override
    public Patient getAuthenticatedPatient(String userName, String password) {
        return loginRespository.findPatientByUsernameAndPassword(userName, password).orElse(null);
    }
}