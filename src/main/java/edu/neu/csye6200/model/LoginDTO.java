package edu.neu.csye6200.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @NotNull(message = "Please fill username")
    private String username;

    @NotNull(message = "Please fill password")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, message = "Password should be greater than 6 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}