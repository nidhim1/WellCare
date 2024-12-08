package edu.neu.csye6200.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }


@GetMapping("/insurance")
public String showInsurancePage() {
    return "insurance";
}

    @GetMapping("/doctor-profile")
    public String showDoctorProfilePage() {
        return "doctor-profile";
    }

    @GetMapping("/staff-appointments")
    public String showStaffAllAppointmentsPage() {
        return "staff-all-appointments";
    }
}
