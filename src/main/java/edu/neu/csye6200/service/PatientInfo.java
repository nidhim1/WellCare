package edu.neu.csye6200.service;

import edu.neu.csye6200.model.PatientInfoDTO;

import java.util.List;

public interface PatientInfo {


    PatientInfoDTO addPatient(PatientInfoDTO patientInfoDTO);

    PatientInfoDTO updatePatient(int patientId, PatientInfoDTO patientInfoDTO);

    PatientInfoDTO getPatientById(int patientId);

    List<PatientInfoDTO> getAllPatients();


}


