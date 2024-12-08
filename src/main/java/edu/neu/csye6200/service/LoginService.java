package edu.neu.csye6200.service;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.entity.Staff;

public interface LoginService {
    boolean authenticatePatient(String userName, String password);
    boolean authenticateStaff(String userName, String password);
    Staff getAuthenticatedStaff(String userName, String password);
    Patient getAuthenticatedPatient(String userName, String password);
}
