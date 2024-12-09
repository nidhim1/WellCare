package edu.neu.csye6200.service;

import edu.neu.csye6200.model.PatientContactInfoDTO;

import java.util.List;
import java.util.Map;

public interface PatientContactInfoService {

    PatientContactInfoDTO savePatientContactInfo(PatientContactInfoDTO patientContactInfoDTO);

    public PatientContactInfoDTO save (PatientContactInfoDTO patientContactInfoDTO);

    List<PatientContactInfoDTO> getAllPatientContactInfo();

    PatientContactInfoDTO getPatientContactInfoById(Long id); // Add this method


    PatientContactInfoDTO updatePatientContactInfo(Long id, Map<String, Object> updates);
}
