package edu.neu.csye6200.service.impl;


import edu.neu.csye6200.model.PrescriptionDTO;
import edu.neu.csye6200.entity.Prescription;
import edu.neu.csye6200.repository.PrescriptionRepository;
import edu.neu.csye6200.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription createPrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setPatientId(prescriptionDTO.getPatientId());
        prescription.setStaffId(prescriptionDTO.getStaffId());
        prescription.setIssueDate(java.sql.Date.valueOf(prescriptionDTO.getIssueDate()));
        prescription.setMedication(prescriptionDTO.getMedication());
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setFrequency(prescriptionDTO.getFrequency());
        prescription.setDuration(prescriptionDTO.getDuration());
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(int id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription updatePrescription(int id, PrescriptionDTO prescriptionDTO) {
        Prescription prescription = prescriptionRepository.findById(id).orElse(null);
        if (prescription != null) {
            prescription.setPatientId(prescriptionDTO.getPatientId());
            prescription.setStaffId(prescriptionDTO.getStaffId());
            prescription.setIssueDate(java.sql.Date.valueOf(prescriptionDTO.getIssueDate()));
            prescription.setMedication(prescriptionDTO.getMedication());
            prescription.setDosage(prescriptionDTO.getDosage());
            prescription.setFrequency(prescriptionDTO.getFrequency());
            prescription.setDuration(prescriptionDTO.getDuration());
            return prescriptionRepository.save(prescription);
        }
        return null;
    }

    @Override
    public void deletePrescription(int id) {
        prescriptionRepository.deleteById(id);
    }
}
