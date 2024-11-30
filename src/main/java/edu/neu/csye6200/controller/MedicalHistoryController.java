package edu.neu.csye6200.controller;


import edu.neu.csye6200.model.MedicalHistoryDTO;
import edu.neu.csye6200.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/history")
public class PatientMedicalHistoryController {

    @Autowired
    private MedicalHistoryService MedicalHistoryService;

    // Get all patient medical history records
    @GetMapping
    public List<MedicalHistoryDTO> getAllHistory() {
        return MedicalHistoryService.getAllHistory();
    }

    // Get medical history by ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryDTO> getHistoryById(@PathVariable Long id) {
        MedicalHistoryDTO history = MedicalHistoryService.getHistoryById(id);
        return history != null ? ResponseEntity.ok(history) : ResponseEntity.notFound().build();
    }

    // Create a new medical history record
    @PostMapping
    public ResponseEntity<MedicalHistoryDTO> createHistory(@RequestBody MedicalHistoryDTO patientMedicalHistoryDTO) {
        MedicalHistoryDTO createdHistory = MedicalHistoryService.createHistory(patientMedicalHistoryDTO);
        return ResponseEntity.status(201).body(createdHistory);
    }

    // Update an existing medical history record
    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistoryDTO> updateHistory(@PathVariable Long id, @RequestBody MedicalHistoryDTO MedicalHistoryDTO) {
        MedicalHistoryDTO updatedHistory = MedicalHistoryService.updateHistory(id, patientMedicalHistoryDTO);
        return ResponseEntity.ok(updatedHistory);
    }

    // Delete a medical history record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id) {
        MedicalHistoryService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}
