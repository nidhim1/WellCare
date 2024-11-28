package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.model.PatientInfoDTO;
import edu.neu.csye6200.repository.PatientInfoRepository;
import edu.neu.csye6200.service.PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientInfoImpl implements PatientInfo {

    @Autowired
    private PatientInfoRepository patientInfoRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public PatientInfoDTO addPatient(PatientInfoDTO patientInfoDTO) {
        Patient patient = mapDTOToEntity(patientInfoDTO);
        Patient savedPatient = patientInfoRepository.save(patient);
        return mapEntityToDTO(savedPatient);
    }

    @Override
    public PatientInfoDTO updatePatient(int patientId, PatientInfoDTO patientInfoDTO) {
        Optional<Patient> optionalPatient = patientInfoRepository.findById(patientId);
        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found with ID: " + patientId);
        }
        Patient patient = optionalPatient.get();
        patient.setFirstName(patientInfoDTO.getFirstName());
        patient.setMiddleName(patientInfoDTO.getMiddleName());
        patient.setLastName(patientInfoDTO.getLastName());
        patient.setUserName(patientInfoDTO.getUserId());
        patient.setPassword(patientInfoDTO.getPassword());
        patient.setGender(Patient.Gender.valueOf(patientInfoDTO.getGender()));
        try {
            patient.setDob(dateFormat.parse(patientInfoDTO.getDob()));
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Expected format: yyyy-MM-dd");
        }
        Patient updatedPatient = patientInfoRepository.save(patient);
        return mapEntityToDTO(updatedPatient);
    }

    @Override
    public PatientInfoDTO getPatientById(int patientId) {
        Optional<Patient> optionalPatient = patientInfoRepository.findById(patientId);
        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found with ID: " + patientId);
        }
        return mapEntityToDTO(optionalPatient.get());
    }

    @Override
    public List<PatientInfoDTO> getAllPatients() {
        List<Patient> patients = patientInfoRepository.findAll();
        return patients.stream().map(this::mapEntityToDTO).collect(Collectors.toList());
    }

    private Patient mapDTOToEntity(PatientInfoDTO dto) {
        Patient patient = new Patient();
        patient.setFirstName(dto.getFirstName());
        patient.setMiddleName(dto.getMiddleName());
        patient.setLastName(dto.getLastName());
        patient.setUserName(dto.getUserId());
        patient.setPassword(dto.getPassword());
        patient.setGender(Patient.Gender.valueOf(dto.getGender()));
        try {
            patient.setDob(dateFormat.parse(dto.getDob()));
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Expected format: yyyy-MM-dd");
        }
        return patient;
    }

    private PatientInfoDTO mapEntityToDTO(Patient entity) {
        PatientInfoDTO dto = new PatientInfoDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setUserId(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setGender(entity.getGender().name());
        dto.setDob(dateFormat.format(entity.getDob()));
        return dto;
    }
}
