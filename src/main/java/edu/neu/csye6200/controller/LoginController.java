package edu.neu.csye6200.controller;

import edu.neu.csye6200.entity.Staff;
import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.service.LoginService;
import edu.neu.csye6200.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
//        boolean isPatientAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());
//        Staff authenticatedStaff = loginService.getAuthenticatedStaff(loginDTO.getUsername(), loginDTO.getPassword());
//
//        Map<String, String> response = new HashMap<>();
//        if (isPatientAuthenticated) {
//            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            Patient authenticatedPatient = loginService.getAuthenticatedPatient(loginDTO.getUsername(), loginDTO.getPassword());
//
//            response.put("token", token);
//            response.put("redirectUrl", "/patient-dashboard");
//            response.put("id", String.valueOf(authenticatedPatient.getPatientId()));
//            response.put("first_name", authenticatedPatient.getFirstName());
//            response.put("middle_name", authenticatedPatient.getMiddleName());
//            response.put("last_name", authenticatedPatient.getLastName());
//            return ResponseEntity.ok(response);
//        } else if (authenticatedStaff != null) {
//            String token = jwtUtil.generateToken(loginDTO.getUsername());
//            response.put("token", token);
//            response.put("id", String.valueOf(authenticatedStaff.getStaffId()));
//            response.put("first_name", authenticatedStaff.getFirstName());
//            response.put("middle_name", authenticatedStaff.getMiddleName());
//            response.put("last_name", authenticatedStaff.getLastName());
//            if ("doctor".equalsIgnoreCase(authenticatedStaff.getRole())) {
//                response.put("redirectUrl", "/doctor-dashboard");
//            } else {
//                response.put("redirectUrl", "/staff-dashboard");
//            }
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        boolean isPatientAuthenticated = loginService.authenticatePatient(loginDTO.getUsername(), loginDTO.getPassword());
        Staff authenticatedStaff = loginService.getAuthenticatedStaff(loginDTO.getUsername(), loginDTO.getPassword());

        Map<String, String> responseBody = new HashMap<>();
        if (isPatientAuthenticated) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
            Patient authenticatedPatient = loginService.getAuthenticatedPatient(loginDTO.getUsername(), loginDTO.getPassword());

            // Store user details in cookies
            createCookie("token", token, response);
            createCookie("id", String.valueOf(authenticatedPatient.getPatientId()), response);
            createCookie("first_name", authenticatedPatient.getFirstName(), response);
            createCookie("middle_name", authenticatedPatient.getMiddleName(), response);
            createCookie("last_name", authenticatedPatient.getLastName(), response);

            responseBody.put("redirectUrl", "/patient-dashboard");
            return ResponseEntity.ok(responseBody);
        } else if (authenticatedStaff != null) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());

            // Store user details in cookies
            createCookie("token", token, response);
            createCookie("id", String.valueOf(authenticatedStaff.getStaffId()), response);
            createCookie("first_name", authenticatedStaff.getFirstName(), response);
            createCookie("middle_name", authenticatedStaff.getMiddleName(), response);
            createCookie("last_name", authenticatedStaff.getLastName(), response);

            if ("doctor".equalsIgnoreCase(authenticatedStaff.getRole())) {
                responseBody.put("redirectUrl", "/doctor-dashboard");
            } else {
                responseBody.put("redirectUrl", "/staff-dashboard");
            }
            return ResponseEntity.ok(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    private void createCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(false); // Allow access from JavaScript
        cookie.setPath("/"); // Accessible across all pages
        cookie.setMaxAge(60 * 60 * 24); // Cookie expires after 1 day
        response.addCookie(cookie);
    }
}