package edu.neu.csye6200.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientInfoPageController {

    @GetMapping("/patient-info")
    public String showPatientInfoPage() {
        return "patient-info"; // Matches the name of the HTML file in the "templates" directory.
    }
}
