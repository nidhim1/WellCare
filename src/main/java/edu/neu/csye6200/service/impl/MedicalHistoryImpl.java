
package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.MedicalHistory;
import edu.neu.csye6200.model.MedicalHistoryDTO;
import edu.neu.csye6200.repository.MedicalHistoryRepository;
import edu.neu.csye6200.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryImpl implements MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistoryDTO> getAllMedicalHistory() {
        return medicalHistoryRepository.findAll().stream().map(history -> convertToDTO(history)).collect(Collectors.toList());
    }

    @Override
    public MedicalHistoryDTO getMedicalHistoryById(Long id) {
        // Fetching the MedicalHistory entity from the repository
        MedicalHistory history = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical history not found with id: " + id));

        // Converting MedicalHistory entity to MedicalHistoryDTO
        MedicalHistoryDTO historyDTO = new MedicalHistoryDTO();

        // Setting the properties of DTO using the fetched entity
        historyDTO.setHistoryId(history.getHistoryId());
        historyDTO.setPatientId(history.getPatientId());
        historyDTO.setAllergies(history.getAllergies());
        historyDTO.setPastDiseases(history.getPastDiseases());
        historyDTO.setOngoingMedication(history.getOngoingMedication());
        historyDTO.setCreatedAt(history.getCreatedAt());
        historyDTO.setUpdatedAt(history.getUpdatedAt());
        historyDTO.setDoctorNotes(history.getDoctorNotes());
        historyDTO.setAllergyType(history.getAllergyType());
        historyDTO.setSeverityOfAllergy(history.getSeverityOfAllergy());
        historyDTO.setActive(history.getIsActive());
        historyDTO.setMedicationChanges(history.getMedicationChanges());
        historyDTO.setPatientNotes(history.getPatientNotes());
        historyDTO.setHistoryStatus(history.getHistoryStatus());

        // Returning the DTO
        return historyDTO;
    }


    @Override
    public MedicalHistoryDTO updateMedicalHistory(Long id, MedicalHistoryDTO patientMedicalHistoryDTO) {
        MedicalHistory history = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical History not found with id: " + id));

        // Corrected: Use the patientMedicalHistoryDTO instance to get values
        history.setAllergies(patientMedicalHistoryDTO.getAllergies());
        history.setPastDiseases(patientMedicalHistoryDTO.getPastDiseases());
        history.setOngoingMedication(patientMedicalHistoryDTO.getOngoingMedication());
        history.setUpdatedAt(LocalDateTime.now());
        history.setDoctorNotes(patientMedicalHistoryDTO.getDoctorNotes());
        history.setAllergyType(patientMedicalHistoryDTO.getAllergyType());
        history.setSeverityOfAllergy(patientMedicalHistoryDTO.getSeverityOfAllergy());
        history.setActive(patientMedicalHistoryDTO.isActive());
        history.setMedicationChanges(patientMedicalHistoryDTO.getMedicationChanges());
        history.setPatientNotes(patientMedicalHistoryDTO.getPatientNotes());
        history.setHistoryStatus(patientMedicalHistoryDTO.getHistoryStatus());

        // Save the updated entity to the repository
        MedicalHistory updatedHistory = medicalHistoryRepository.save(history);

        // Convert the updated entity to DTO and return it
        return convertToDTO(updatedHistory);
    }


    @Override
    public void deleteMedicalHistory(Long id) {
        medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical history not found with id: " + id));
        medicalHistoryRepository.deleteById(id);
    }

    @Override
    public MedicalHistoryDTO saveMedicalHistory(MedicalHistoryDTO MedicalHistoryDTO) {
        MedicalHistory history = new MedicalHistory();
        history.setPatientId(MedicalHistoryDTO.getPatientId());
        history.setAllergies(MedicalHistoryDTO.getAllergies());
        history.setPastDiseases(MedicalHistoryDTO.getPastDiseases());
        history.setOngoingMedication(MedicalHistoryDTO.getOngoingMedication());
        history.setCreatedAt(LocalDateTime.now());
        history.setUpdatedAt(LocalDateTime.now());
        history.setDoctorNotes(MedicalHistoryDTO.getDoctorNotes());
        history.setAllergyType(MedicalHistoryDTO.getAllergyType());
        history.setSeverityOfAllergy(MedicalHistoryDTO.getSeverityOfAllergy());
        history.setActive(MedicalHistoryDTO.isActive());
        history.setMedicationChanges(MedicalHistoryDTO.getMedicationChanges());
        history.setPatientNotes(MedicalHistoryDTO.getPatientNotes());
        history.setHistoryStatus(MedicalHistoryDTO.getHistoryStatus());

        MedicalHistory savedHistory = medicalHistoryRepository.save(history);

        return convertToDTO(savedHistory);
    }

    private MedicalHistoryDTO convertToDTO(MedicalHistory history) {
        MedicalHistoryDTO dto = new MedicalHistoryDTO();
        dto.setHistoryId(history.getHistoryId());
        dto.setPatientId(history.getPatientId());
        dto.setAllergies(history.getAllergies());
        dto.setPastDiseases(history.getPastDiseases());
        dto.setOngoingMedication(history.getOngoingMedication());
        dto.setCreatedAt(history.getCreatedAt());
        dto.setUpdatedAt(history.getUpdatedAt());
        dto.setDoctorNotes(history.getDoctorNotes());
        dto.setAllergyType(history.getAllergyType());
        dto.setSeverityOfAllergy(history.getSeverityOfAllergy());
        dto.setActive(history.getIsActive());
        dto.setMedicationChanges(history.getMedicationChanges());
        dto.setPatientNotes(history.getPatientNotes());
        dto.setHistoryStatus(history.getHistoryStatus());
        return dto;
    }

    @Override
    public List<MedicalHistoryDTO> getMedicalHistoryByPatientId(Long patientId) {
        List<MedicalHistory> histories = medicalHistoryRepository.findByPatientId(patientId);

        if (histories.isEmpty()) {
            throw new RuntimeException("No medical history found for patientId: " + patientId);
        }

        return histories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


}
