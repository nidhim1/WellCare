package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.PatientContactInfoDTO;
import edu.neu.csye6200.service.PatientContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PatientContactInfoController {

    @Autowired
    private PatientContactInfoService patientContactInfoService;

    @GetMapping("/PatientContactInfo")
    public String PatientContactInfo(){
        return "Hello World";
    }

    @PostMapping("/patientcontactinfo")
    public PatientContactInfoDTO savePatientContactInfo(@RequestBody PatientContactInfoDTO patientContactInfoDTO){
        patientContactInfoService.savePatientContactInfo(patientContactInfoDTO);
        System.out.println(patientContactInfoDTO);
        return patientContactInfoDTO;
    }


}
