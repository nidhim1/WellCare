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
        Insurance insurance = new Insurance();
        insurance.setPatientId(insuranceDTO.getPatientId());
        insurance.setInsuranceNumber(insuranceDTO.getInsuranceNumber());
        insurance.setInsuranceProvider(insuranceDTO.getInsuranceProvider());
        insurance.setInsuranceType(insuranceDTO.getInsuranceType());

        // Handle nullable insurance_date
        if (insuranceDTO.getInsuranceDate() != null && !insuranceDTO.getInsuranceDate().isEmpty()) {
            insurance.setInsuranceDate(parseInsuranceDate(insuranceDTO.getInsuranceDate()));
        } else {
            insurance.setInsuranceDate(null); // Set null if no date provided
        }

        insurance.setCoverageDetails(insuranceDTO.getCoverageDetails());

        Insurance savedInsurance = insuranceRepository.save(insurance);

        InsuranceDTO savedInsuranceDTO = new InsuranceDTO();
        savedInsuranceDTO.setPatientId(savedInsurance.getPatientId());
        savedInsuranceDTO.setInsuranceNumber(savedInsurance.getInsuranceNumber());
        savedInsuranceDTO.setInsuranceProvider(savedInsurance.getInsuranceProvider());
        savedInsuranceDTO.setInsuranceType(savedInsurance.getInsuranceType());
        savedInsuranceDTO.setInsuranceDate(
                savedInsurance.getInsuranceDate() != null
                        ? formatInsuranceDate(savedInsurance.getInsuranceDate())
                        : null
        );
        savedInsuranceDTO.setCoverageDetails(savedInsurance.getCoverageDetails());

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
