package edu.neu.csye6200.controller;

import edu.neu.csye6200.entity.MedicalHistory;
import edu.neu.csye6200.model.MedicalHistoryDTO;
import edu.neu.csye6200.service.MedicalHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicalhistory")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    // Get all medical histories
    @GetMapping("/MedicalHistory")
    public ResponseEntity<List<MedicalHistoryDTO>> getAllMedicalHistories() {
        List<MedicalHistoryDTO> histories = medicalHistoryService.getAllMedicalHistory();
        return ResponseEntity.ok(histories);
    }

    // Get medical history by ID
    @GetMapping("/MedicalHistory/{id}")
    public ResponseEntity<MedicalHistoryDTO> getMedicalHistoryById(@PathVariable Long id) {
        MedicalHistoryDTO history = medicalHistoryService.getMedicalHistoryById(id);
        return ResponseEntity.ok(history);
    }

    // Create new medical history
    @PostMapping("/MedicalHistory")
    public ResponseEntity<MedicalHistoryDTO> createMedicalHistory(@Valid @RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistoryDTO savedHistory = medicalHistoryService.saveMedicalHistory(medicalHistoryDTO);
        return ResponseEntity.ok(savedHistory);
    }


    // Update existing medical history by ID
    @PutMapping("/MedicalHistory/{id}")
    public ResponseEntity<MedicalHistoryDTO> updateMedicalHistory(
            @PathVariable Long id,
            @RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistoryDTO updatedHistory = medicalHistoryService.updateMedicalHistory(id, medicalHistoryDTO);
        return ResponseEntity.ok(updatedHistory);
    }

    // Delete medical history by ID
    @DeleteMapping("/MedicalHistory/{id}")
    public ResponseEntity<String> deleteMedicalHistory(@PathVariable Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return ResponseEntity.ok("Medical history deleted successfully.");
    }

    @GetMapping("/medical-history/{id}")
    public ResponseEntity<List<MedicalHistoryDTO>> getMedicalHistoryByPatientId(@PathVariable("id") Long patientId) {
        List<MedicalHistoryDTO> histories = medicalHistoryService.getMedicalHistoryByPatientId(patientId);
        return ResponseEntity.ok(histories);
    }


}
