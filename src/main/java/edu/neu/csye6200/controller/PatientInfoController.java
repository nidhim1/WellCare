package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.PatientInfoDTO;
import edu.neu.csye6200.service.PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-info")
public class PatientInfoController {

    @Autowired
    private PatientInfo patientInfo;

    @PostMapping
    public ResponseEntity<PatientInfoDTO> addPatient(@RequestBody PatientInfoDTO patientInfoDTO) {
        PatientInfoDTO createdPatient = patientInfo.addPatient(patientInfoDTO);
        return ResponseEntity.ok(createdPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientInfoDTO> updatePatient(
            @PathVariable("id") int patientId,
            @RequestBody PatientInfoDTO patientInfoDTO) {
        PatientInfoDTO updatedPatient = patientInfo.updatePatient(patientId, patientInfoDTO);
        return ResponseEntity.ok(updatedPatient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientInfoDTO> getPatientById(@PathVariable("id") int patientId) {
        PatientInfoDTO patient = patientInfo.getPatientById(patientId);
        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientInfoDTO>> getAllPatients() {
        List<PatientInfoDTO> patients = patientInfo.getAllPatients();
        return ResponseEntity.ok(patients);
    }


}
