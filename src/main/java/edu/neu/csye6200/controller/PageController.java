package edu.neu.csye6200.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }


    @GetMapping("/insurance")
    public String showInsurancePage() {
        return "insurance";
    }

@GetMapping("/patient-profile")
    public String showPatientProfilePage() { return "patient-profile";}

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

    @GetMapping("/medical-history")
    public String showMedicalHistoryPage() {
        return "medical-history";
    }

   public String showPatientDashboardPage() { return "patient-dashboard"; }

    // Prescription Management Page
    @GetMapping("/prescriptions-management")
    public String showPrescriptionManagementPage() {
        return "prescriptions";
    }

    @GetMapping("/patient-info")
    public String showPatientInfoPage() {
        return "patient-info"; // Map to patient-info.html
    }

    @GetMapping("/staff-profile")
    public String staffProfilePage() {
        return "staffprofile"; // Return the name of your HTML file without the .html extension
    }

    @GetMapping("/staffprofiletesting")
    public String showStaffProfilePage() {
        return "staffprofiletesting"; // Name of the HTML file in the templates folder
    }

}


