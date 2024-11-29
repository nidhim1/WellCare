package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Insurance;
import edu.neu.csye6200.model.InsuranceDTO;
import edu.neu.csye6200.repository.InsuranceRepository;
import edu.neu.csye6200.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public List<InsuranceDTO> getAllInsurance() {
        List<Insurance> insurances = insuranceRepository.findAll();

        // Map the list of Insurance entities to a list of InsuranceDTOs
        return insurances.stream().map(insurance -> {
            InsuranceDTO dto = new InsuranceDTO();
            dto.setPatientId(insurance.getPatientId());
            dto.setInsuranceNumber(insurance.getInsuranceNumber());
            dto.setInsuranceProvider(insurance.getInsuranceProvider());
            dto.setInsuranceType(insurance.getInsuranceType());
            dto.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(insurance.getInsuranceDate()));
            dto.setCoverageDetails(insurance.getCoverageDetails());
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public InsuranceDTO getInsuranceById(int id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));

        InsuranceDTO dto = new InsuranceDTO();
        dto.setPatientId(insurance.getPatientId());
        dto.setInsuranceNumber(insurance.getInsuranceNumber());
        dto.setInsuranceProvider(insurance.getInsuranceProvider());
        dto.setInsuranceType(insurance.getInsuranceType());
        dto.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(insurance.getInsuranceDate()));
        dto.setCoverageDetails(insurance.getCoverageDetails());
        return dto;
    }

    @Override
    public InsuranceDTO updateInsurance(int id, InsuranceDTO insuranceDTO) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));

        insurance.setInsuranceNumber(insuranceDTO.getInsuranceNumber());
        insurance.setInsuranceProvider(insuranceDTO.getInsuranceProvider());
        insurance.setInsuranceType(insuranceDTO.getInsuranceType());
        try {
            insurance.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").parse(insuranceDTO.getInsuranceDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        insurance.setCoverageDetails(insuranceDTO.getCoverageDetails());

        Insurance updatedInsurance = insuranceRepository.save(insurance);

        InsuranceDTO updatedDTO = new InsuranceDTO();
        updatedDTO.setInsuranceNumber(updatedInsurance.getInsuranceNumber());
        updatedDTO.setInsuranceProvider(updatedInsurance.getInsuranceProvider());
        updatedDTO.setInsuranceType(updatedInsurance.getInsuranceType());
        updatedDTO.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(updatedInsurance.getInsuranceDate()));
        updatedDTO.setCoverageDetails(updatedInsurance.getCoverageDetails());
        return updatedDTO;
    }


    @Override
    public void deleteInsurance(int id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));
        insuranceRepository.delete(insurance);
    }



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
