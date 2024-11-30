package edu.neu.csye6200.service;

import edu.neu.csye6200.model.PatientContactInfoDTO;

public interface PatientContactInfoService {

    PatientContactInfoDTO savePatientContactInfo(PatientContactInfoDTO patientContactInfoDTO);

    public PatientContactInfoDTO save (PatientContactInfoDTO patientContactInfoDTO);
}
