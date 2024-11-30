
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
        MedicalHistory history = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical History not found with id: " + id));
        return convertToDTO(history);
    }

    @Override
    public MedicalHistoryDTO updateMedicalHistory(Long id, MedicalHistoryDTO patientMedicalHistoryDTO) {
        MedicalHistory history = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical History not found with id: " + id));

        history.setAllergies(MedicalHistoryDTO.getAllergies());
        history.setPastDiseases(MedicalHistoryDTO.getPastDiseases());
        history.setOngoingMedication(MedicalHistoryDTO.getOngoingMedication());
        history.setUpdatedAt(LocalDateTime.now());
        history.setDoctorNotes(MedicalHistoryDTO.getDoctorNotes());
        history.setAllergyType(MedicalHistoryDTO.getAllergyType());
        history.setSeverityOfAllergy(MedicalHistoryDTO.getSeverityOfAllergy());
        history.setActive(MedicalHistoryDTO.isActive());
        history.setMedicationChanges(MedicalHistoryDTO.getMedicationChanges());
        history.setPatientNotes(MedicalHistoryDTO.getPatientNotes());
        history.setHistoryStatus(MedicalHistoryDTO.getHistoryStatus());

        MedicalHistory updatedHistory = medicalHistoryRepository.save(history);

        return convertToDTO(updatedHistory);
    }

    @Override
    public void deleteMedicalHistory(Long id) {
        MedicalHistory history = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical History not found with id: " + id));
        medicalHistoryRepository.delete(history);
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
        dto.setActive(history.isActive());
        dto.setMedicationChanges(history.getMedicationChanges());
        dto.setPatientNotes(history.getPatientNotes());
        dto.setHistoryStatus(history.getHistoryStatus());
        return dto;
    }
}
