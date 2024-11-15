package edu.neu.csye6200.service;

import edu.neu.csye6200.model.LoginDTO;

public interface LoginService {
    boolean authenticate(String userName, String password);
}
