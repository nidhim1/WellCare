package edu.neu.csye6200.controller;

import edu.neu.csye6200.entity.Staff;
import edu.neu.csye6200.entity.Patient;
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
        Staff authenticatedStaff = loginService.getAuthenticatedStaff(loginDTO.getUsername(), loginDTO.getPassword());

        Map<String, String> response = new HashMap<>();
        if (isPatientAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
            Patient authenticatedPatient = loginService.getAuthenticatedPatient(loginDTO.getUsername(), loginDTO.getPassword());

            response.put("token", token);
            response.put("redirectUrl", "/patient-dashboard");
            response.put("id", String.valueOf(authenticatedPatient.getPatientId()));
            response.put("first_name", authenticatedPatient.getFirstName());
            response.put("middle_name", authenticatedPatient.getMiddleName());
            response.put("last_name", authenticatedPatient.getLastName());
            return ResponseEntity.ok(response);
        } else if (authenticatedStaff != null) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
            response.put("token", token);
            response.put("id", String.valueOf(authenticatedStaff.getStaffId()));
            response.put("first_name", authenticatedStaff.getFirstName());
            response.put("middle_name", authenticatedStaff.getMiddleName());
            response.put("last_name", authenticatedStaff.getLastName());
            if ("doctor".equalsIgnoreCase(authenticatedStaff.getRole())) {
                response.put("redirectUrl", "/doctor-dashboard");
            } else {
                response.put("redirectUrl", "/staff-dashboard");
            }
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}