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
        return insuranceRepository.findAll().stream().map(insurance -> {
            InsuranceDTO dto = new InsuranceDTO();
            dto.setInsuranceNumber(insurance.getInsuranceNumber());
            dto.setInsuranceProvider(insurance.getInsuranceProvider());
            dto.setCoverageDetails(insurance.getCoverageDetails());
            dto.setInsuranceType(insurance.getInsuranceType());

            // Handle null insuranceDate
            if (insurance.getInsuranceDate() != null) {
                dto.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(insurance.getInsuranceDate()));
            } else {
                dto.setInsuranceDate(null); // Or set a default value, e.g., "N/A"
            }

            return dto;
        }).collect(Collectors.toList());
    }



    @Override
    public InsuranceDTO getInsuranceByPatientId(int patientId) {
//        Insurance insurance = insuranceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));
//
//        InsuranceDTO dto = new InsuranceDTO();
//        dto.setPatientId(insurance.getPatientId());
//        dto.setInsuranceNumber(insurance.getInsuranceNumber());
//        dto.setInsuranceProvider(insurance.getInsuranceProvider());
//        dto.setInsuranceType(insurance.getInsuranceType());
//        dto.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(insurance.getInsuranceDate()));
//        dto.setCoverageDetails(insurance.getCoverageDetails());
//        return dto;

        Insurance insurance = insuranceRepository.findByPatientId(patientId)
                .orElseThrow(() -> new RuntimeException("Insurance not found for patientId: " + patientId));

        InsuranceDTO dto = new InsuranceDTO();
        dto.setPatientId(insurance.getPatientId());
        dto.setInsuranceNumber(insurance.getInsuranceNumber());
        dto.setInsuranceProvider(insurance.getInsuranceProvider());
        dto.setInsuranceType(insurance.getInsuranceType());

        if (insurance.getInsuranceDate() != null) {
            dto.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").format(insurance.getInsuranceDate()));
        } else {
            dto.setInsuranceDate(null);
        }

        dto.setCoverageDetails(insurance.getCoverageDetails());
        return dto;
    }

    @Override
    public InsuranceDTO updateInsurance(int patientId, InsuranceDTO insuranceDTO) {
        Insurance insurance = insuranceRepository.findByPatientId(patientId)
                .orElseThrow(() -> new RuntimeException("Insurance not found for patientId: " + patientId));

        // Update only the fields that are present in the DTO (non-null)
        if (insuranceDTO.getInsuranceNumber() != null) {
            insurance.setInsuranceNumber(insuranceDTO.getInsuranceNumber());
        }
        if (insuranceDTO.getInsuranceProvider() != null) {
            insurance.setInsuranceProvider(insuranceDTO.getInsuranceProvider());
        }
        if (insuranceDTO.getInsuranceType() != null) {
            insurance.setInsuranceType(insuranceDTO.getInsuranceType());
        }
        if (insuranceDTO.getInsuranceDate() != null) {
            try {
                insurance.setInsuranceDate(new SimpleDateFormat("yyyy-MM-dd").parse(insuranceDTO.getInsuranceDate()));
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format. Expected format: yyyy-MM-dd");
            }
        }
        if (insuranceDTO.getCoverageDetails() != null) {
            insurance.setCoverageDetails(insuranceDTO.getCoverageDetails());
        }

        // Save the updated insurance
        Insurance updatedInsurance = insuranceRepository.save(insurance);

        // Map updated insurance entity back to DTO
        InsuranceDTO updatedDTO = new InsuranceDTO();
        updatedDTO.setPatientId(updatedInsurance.getPatientId());
        updatedDTO.setInsuranceNumber(updatedInsurance.getInsuranceNumber());
        updatedDTO.setInsuranceProvider(updatedInsurance.getInsuranceProvider());
        updatedDTO.setInsuranceType(updatedInsurance.getInsuranceType());
        updatedDTO.setInsuranceDate(
                updatedInsurance.getInsuranceDate() != null
                        ? new SimpleDateFormat("yyyy-MM-dd").format(updatedInsurance.getInsuranceDate())
                        : null
        );
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
