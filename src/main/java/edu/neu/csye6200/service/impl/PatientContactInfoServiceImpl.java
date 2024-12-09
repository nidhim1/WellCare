package edu.neu.csye6200.service.impl;
import edu.neu.csye6200.entity.PatientContactInfoEntity;
import edu.neu.csye6200.exception.ResourceNotFoundException;
import edu.neu.csye6200.model.PatientContactInfoDTO;
import edu.neu.csye6200.repository.PatientContactInfoRepository;
import edu.neu.csye6200.service.PatientContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PatientContactInfoServiceImpl implements PatientContactInfoService {

    @Autowired
    private PatientContactInfoRepository patientContactInfoRepository;

    @Override
    public PatientContactInfoDTO getPatientContactInfoById(Long id) {
        // Find the entity by ID
        PatientContactInfoEntity entity = patientContactInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact Info not found with ID: " + id));

        // Map the entity to DTO
        PatientContactInfoDTO dto = new PatientContactInfoDTO();
        dto.setPatientId(entity.getPatientId());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setPostalCode(entity.getPostalCode());
        dto.setCountry(entity.getCountry());

        return dto;
    }


    @Override
    public PatientContactInfoDTO savePatientContactInfo(PatientContactInfoDTO patientContactInfoDTO) {

        PatientContactInfoEntity patientContactInfoEntity = new PatientContactInfoEntity();
        patientContactInfoEntity.setPatientId((long) patientContactInfoDTO.getPatientId());
        patientContactInfoEntity.setPhoneNumber(Integer.parseInt(String.valueOf(patientContactInfoDTO.getPhoneNumber())));
        patientContactInfoEntity.setEmail(patientContactInfoDTO.getEmail());
        patientContactInfoEntity.setAddress(patientContactInfoDTO.getAddress());
        patientContactInfoEntity.setCity(patientContactInfoDTO.getCity());
        patientContactInfoEntity.setState(patientContactInfoDTO.getState());
        patientContactInfoEntity.setPostalCode(patientContactInfoEntity.getPostalCode());
        patientContactInfoEntity.setCountry(patientContactInfoDTO.getCountry());


        patientContactInfoRepository.save(patientContactInfoEntity);
        return null;
    }

    @Override
    public PatientContactInfoDTO save(PatientContactInfoDTO patientContactInfoDTO) {
        return null;
    }

    @Override
    public List<PatientContactInfoDTO> getAllPatientContactInfo() {
        // Fetch all contact info records and map to DTO
        return patientContactInfoRepository.findAll()
                .stream()
                .map(entity -> {
                    PatientContactInfoDTO dto = new PatientContactInfoDTO();
                    dto.setPatientId(entity.getPatientId());
                    dto.setPhoneNumber(entity.getPhoneNumber());
                    dto.setEmail(entity.getEmail());
                    dto.setAddress(entity.getAddress());
                    dto.setCity(entity.getCity());
                    dto.setState(entity.getState());
                    dto.setPostalCode(entity.getPostalCode());
                    dto.setCountry(entity.getCountry());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PatientContactInfoDTO updatePatientContactInfo(Long id, Map<String, Object> updates) {
        PatientContactInfoEntity existingContactInfo = patientContactInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact Info not found with ID: " + id));

        // Apply updates dynamically
        updates.forEach((key, value) -> {
            switch (key) {
                case "phoneNumber":
                    existingContactInfo.setPhoneNumber(Integer.parseInt((String) value));
                    break;
                case "email":
                    existingContactInfo.setEmail((String) value);
                    break;
                case "address":
                    existingContactInfo.setAddress((String) value);
                    break;
                case "city":
                    existingContactInfo.setCity((String) value);
                    break;
                case "state":
                    existingContactInfo.setState((String) value);
                    break;
                case "postalCode":
                    existingContactInfo.setPostalCode((String) value);
                    break;
                case "country":
                    existingContactInfo.setCountry((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        // Save updated contact info
        patientContactInfoRepository.save(existingContactInfo);

        // Convert to DTO and return
        PatientContactInfoDTO updatedDTO = new PatientContactInfoDTO();
        updatedDTO.setPatientId(existingContactInfo.getPatientId());
        updatedDTO.setPhoneNumber(existingContactInfo.getPhoneNumber());
        updatedDTO.setEmail(existingContactInfo.getEmail());
        updatedDTO.setAddress(existingContactInfo.getAddress());
        updatedDTO.setCity(existingContactInfo.getCity());
        updatedDTO.setState(existingContactInfo.getState());
        updatedDTO.setPostalCode(existingContactInfo.getPostalCode());
        updatedDTO.setCountry(existingContactInfo.getCountry());

        return updatedDTO;
    }
}
