package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Insurance;
import edu.neu.csye6200.model.InsuranceDTO;
import edu.neu.csye6200.repository.InsuranceRepository;
import edu.neu.csye6200.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public InsuranceDTO saveInsurance(InsuranceDTO insuranceDTO) {
        // Map InsuranceDTO to Insurance entity
        Insurance insurance = new Insurance();
        insurance.setInsuranceNumber(insuranceDTO.getInsuranceNumber());
        insurance.setInsuranceProvider(insuranceDTO.getInsuranceProvider());
        insurance.setCoverageDetails(insuranceDTO.getCoverageDetails());

        // Parse and map additional fields (e.g., date and type)
//        insurance.setInsuranceType(insuranceDTO.getInsuranceType());
//        insurance.setInsuranceDate(parseInsuranceDate(insuranceDTO.getInsuranceDate()));

        // Save the entity in the database
        Insurance savedInsurance = insuranceRepository.save(insurance);

        // Map the saved Insurance entity back to a DTO
        InsuranceDTO savedInsuranceDTO = new InsuranceDTO();
        savedInsuranceDTO.setInsuranceNumber(savedInsurance.getInsuranceNumber());
        savedInsuranceDTO.setInsuranceProvider(savedInsurance.getInsuranceProvider());
        savedInsuranceDTO.setCoverageDetails(savedInsurance.getCoverageDetails());
//        savedInsuranceDTO.setInsuranceType(savedInsurance.getInsuranceType());
//        savedInsuranceDTO.setInsuranceDate(formatInsuranceDate(savedInsurance.getInsuranceDate()));

        return savedInsuranceDTO;
    }

    // Helper method to parse a date from a String
    private java.util.Date parseInsuranceDate(String dateString) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (java.text.ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateString);
        }
    }

    // Helper method to format a Date to a String
    private String formatInsuranceDate(java.util.Date date) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
