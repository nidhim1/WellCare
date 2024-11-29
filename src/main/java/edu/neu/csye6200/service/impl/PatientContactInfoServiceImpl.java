package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.PatientContactInfoEntity;
import edu.neu.csye6200.model.PatientContactInfoDTO;
import edu.neu.csye6200.repository.PatientContactInfoRepository;
import edu.neu.csye6200.service.PatientContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientContactInfoServiceImpl implements PatientContactInfoService {

    @Autowired
    private PatientContactInfoRepository patientContactInfoRepository;

    @Override
    public PatientContactInfoDTO savePatientContactInfo(PatientContactInfoDTO patientContactInfoDTO) {

        PatientContactInfoEntity patientContactInfoEntity = new PatientContactInfoEntity();
        patientContactInfoEntity.setPatientId(patientContactInfoDTO.getPatientId());
        patientContactInfoEntity.setPhoneNumber(patientContactInfoDTO.getPhoneNumber());
        patientContactInfoEntity.setEmail(patientContactInfoDTO.getEmail());
        patientContactInfoEntity.setAddress(patientContactInfoDTO.getAddress());
        patientContactInfoEntity.setCity(patientContactInfoDTO.getCity());
        patientContactInfoEntity.setState(patientContactInfoDTO.getState());
        patientContactInfoEntity.setPostalCode(patientContactInfoDTO.getPostalCode());
        patientContactInfoEntity.setCountry(patientContactInfoDTO.getCountry());


        patientContactInfoRepository.save(patientContactInfoEntity);
        return null;
    }

    @Override
    public PatientContactInfoDTO save(PatientContactInfoDTO patientContactInfoDTO) {
        return null;
    }
}
