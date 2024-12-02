package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.service.LoginService;
import edu.neu.csye6200.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
        boolean isPatientAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());
        boolean isStaffAuthenticated = loginService.authenticateStaff(loginDTO.getUsername(), loginDTO.getPassword());

        Map<String, String> response = new HashMap<>();
        if (isPatientAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            return ResponseEntity.ok("/patient-dashboard");
            response.put("token", token);
            response.put("redirectUrl", "/patient-dashboard");
            return ResponseEntity.ok(response);
        } else if (isStaffAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            return ResponseEntity.ok("/staff-dashboard");
            response.put("token", token);
            response.put("redirectUrl", "/staff-dashboard");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}