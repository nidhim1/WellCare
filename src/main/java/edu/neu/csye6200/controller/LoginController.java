package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean isPatientAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());
        boolean isStaffAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());

        if (isPatientAuthenticated) {
            return ResponseEntity.ok("/patient-dashboard");
        } else if (isStaffAuthenticated) {
            return ResponseEntity.ok("/staff-dashboard");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }
    }
}
