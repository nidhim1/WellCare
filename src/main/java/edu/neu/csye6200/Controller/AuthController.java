package edu.neu.csye6200.Controller;

import edu.neu.csye6200.Model.UserDAO;

public class AuthController {
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {
        return userDAO.validateUser(username, password);
    }
}
