package edu.neu.csye6200.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prescriptions-management")
public class PrescriptionManagementController {

    // Serve the prescriptions management page (HTML)
    @GetMapping
    public String showPrescriptionManagementPage() {
        return "prescriptions"; // This assumes the HTML file is in the templates folder
    }
}
