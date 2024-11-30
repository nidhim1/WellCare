package edu.neu.csye6200.service;



import edu.neu.csye6200.model.PrescriptionDTO;
import edu.neu.csye6200.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription createPrescription(PrescriptionDTO prescriptionDTO);
    Prescription getPrescriptionById(int id);
    List<Prescription> getAllPrescriptions();
    Prescription updatePrescription(int id, PrescriptionDTO prescriptionDTO);
    void deletePrescription(int id);
}
