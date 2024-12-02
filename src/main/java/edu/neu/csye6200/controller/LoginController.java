package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.service.LoginService;
import edu.neu.csye6200.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean isPatientAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());
        boolean isStaffAuthenticated = loginService.authenticateStaff(loginDTO.getUsername(), loginDTO.getPassword());

        if (isPatientAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            return ResponseEntity.ok("/patient-dashboard");
            return ResponseEntity.ok(token);
        } else if (isStaffAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            return ResponseEntity.ok("/staff-dashboard");
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }
    }
}