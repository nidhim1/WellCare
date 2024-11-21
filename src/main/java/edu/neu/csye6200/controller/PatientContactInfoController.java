package edu.neu.csye6200.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PatientContactInfoController {

    @GetMapping("/PatientContactInfo")
    public String PatientContactInfo(){
        return "Hello World";
    }

}
