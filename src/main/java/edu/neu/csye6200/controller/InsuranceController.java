package edu.neu.csye6200.controller;


import edu.neu.csye6200.model.InsuranceDTO;
import edu.neu.csye6200.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/Insurance")
    public InsuranceDTO saveInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        System.out.println("Received payload: " + insuranceDTO);
        return insuranceService.saveInsurance(insuranceDTO);
    }

}
