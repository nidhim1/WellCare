package edu.neu.csye6200.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PatientInfoController {

    @GetMapping("/PatientInfo")
    public String PatientInfo(){
        return "Hello ";
    }

}
