package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.repository.PatientRespository;
import edu.neu.csye6200.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PatientRespository patientRespository;

    @Override
    public boolean authenticate(String userName, String password) {
        Optional<Patient> patient = patientRespository.findByUserNameAndPassword(userName, password);
        return patient.isPresent();
    }
}