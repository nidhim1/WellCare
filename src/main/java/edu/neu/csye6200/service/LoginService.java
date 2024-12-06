package edu.neu.csye6200.service;

public interface LoginService {
    boolean authenticatePatient(String userName, String password);
    boolean authenticateStaff(String userName, String password);
}
