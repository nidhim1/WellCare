package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.PatientContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientContactInfoRepository extends JpaRepository<PatientContactInfoEntity, Long> {
    default Optional<PatientContactInfoEntity> findByPatientId(Long patientId) {
        return null;
    }
}
