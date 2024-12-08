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

@GetMapping("/patient-profile")
    public String showPatientProfilePage() {return "patient-profile";}

    @GetMapping("/appointment")
    public String showAppointmentPage() { return "appointment"; }

    @GetMapping("/scheduleappointment")
    public String showScheduleAppointmentPage() { return "scheduleappointment"; }

    @GetMapping("/staffappointment")
    public String showStaffAppointmentPage() { return "staffappointment"; }

    @GetMapping("/doctor-profile")
    public String showDoctorProfilePage() {
        return "doctor-profile";
    }

    @GetMapping("/staff-appointments")
    public String showStaffAllAppointmentsPage() {
        return "staff-all-appointments";
    }

}
