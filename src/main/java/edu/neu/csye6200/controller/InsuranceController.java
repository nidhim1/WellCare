package edu.neu.csye6200.controller;


import edu.neu.csye6200.model.InsuranceDTO;
import edu.neu.csye6200.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;


    @GetMapping("/Insurance/{id}")
    public InsuranceDTO getInsuranceById(@PathVariable int id) {
        return insuranceService.getInsuranceByPatientId(id);
    }

    @GetMapping("/Insurance")
    public List<InsuranceDTO> getAllInsurance() {
        return insuranceService.getAllInsurance();
    }



    @PostMapping("/Insurance")
    public InsuranceDTO saveInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        System.out.println("Received payload: " + insuranceDTO);
        return insuranceService.saveInsurance(insuranceDTO);
    }

    @PutMapping("/Insurance/{id}")
    public InsuranceDTO updateInsurance(@PathVariable int id, @RequestBody InsuranceDTO insuranceDTO) {
        return insuranceService.updateInsurance(id, insuranceDTO);
    }

    @DeleteMapping("/Insurance/{id}")
    public String deleteInsurance(@PathVariable int id) {
        insuranceService.deleteInsurance(id);
        return "Insurance deleted successfully!";
    }



}
