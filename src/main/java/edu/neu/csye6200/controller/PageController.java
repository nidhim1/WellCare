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
<<<<<<< HEAD
@GetMapping("/patient-profile")
    public String showPatientProfilePage() {
        return "patient-profile";
}

=======

    @GetMapping("/appointment")
    public String showAppointmentPage() { return "appointment"; }

    @GetMapping("/scheduleappointment")
    public String showScheduleAppointmentPage() { return "scheduleappointment"; }

    @GetMapping("/staffappointment")
    public String showStaffAppointmentPage() { return "staffappointment"; }
>>>>>>> 0664128 (Made UI for Patient Appointment, Patient Schedule Appointment and Staff Appointment)
}
