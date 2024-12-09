package edu.neu.csye6200.service;

import edu.neu.csye6200.model.InsuranceDTO;
import java.util.List;

public interface InsuranceService {
    InsuranceDTO saveInsurance(InsuranceDTO insuranceDTO);
    List<InsuranceDTO> getAllInsurance();
    InsuranceDTO getInsuranceByPatientId(int id);
    InsuranceDTO updateInsurance(int id, InsuranceDTO insuranceDTO);
    void deleteInsurance(int id);
}

