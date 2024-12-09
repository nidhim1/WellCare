
package edu.neu.csye6200.service;

import edu.neu.csye6200.model.MedicalHistoryDTO;
import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDTO saveMedicalHistory(MedicalHistoryDTO patientMedicalHistoryDTO);
    List<MedicalHistoryDTO> getAllMedicalHistory();
    MedicalHistoryDTO getMedicalHistoryById(Long id);
    MedicalHistoryDTO updateMedicalHistory(Long id, MedicalHistoryDTO patientMedicalHistoryDTO);
    void deleteMedicalHistory(Long id);
    List<MedicalHistoryDTO> getMedicalHistoryByPatientId(Long patientId);
}
