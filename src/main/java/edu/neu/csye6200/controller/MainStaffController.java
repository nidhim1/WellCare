package edu.neu.csye6200.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainStaffController {

    @GetMapping("/main-staff-dashboard")
    public String staffDashboard() {
        // Returns the updated HTML file
        return "main-staff-dashboard";
    }
}
