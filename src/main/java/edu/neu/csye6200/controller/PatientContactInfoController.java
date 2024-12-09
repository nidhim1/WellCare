package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.PatientContactInfoDTO;
import edu.neu.csye6200.service.PatientContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PatientContactInfoController {

    @Autowired
    private PatientContactInfoService patientContactInfoService;



    @PostMapping("/patientcontactinfo")
    public PatientContactInfoDTO savePatientContactInfo(@RequestBody PatientContactInfoDTO patientContactInfoDTO){
        patientContactInfoService.savePatientContactInfo(patientContactInfoDTO);
        System.out.println(patientContactInfoDTO);
        return patientContactInfoDTO;
    }

    // Fetch All Patient Contact Info
    @GetMapping("/patientcontactinfo")
    public List<PatientContactInfoDTO> getAllPatientContactInfo() {
        return patientContactInfoService.getAllPatientContactInfo();
    }

    // Fetch Patient Contact Info by ID
    @GetMapping("/patientcontactinfo/{id}")
    public PatientContactInfoDTO getPatientContactInfoById(@PathVariable Long id) {
        return patientContactInfoService.getPatientContactInfoById(id);
    }

    // Update Specific Fields in Patient Contact Info (PATCH)
    @PatchMapping("/patientcontactinfo/{id}")
    public PatientContactInfoDTO updatePatientContactInfo(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return patientContactInfoService.updatePatientContactInfo(id, updates);
    }




}
