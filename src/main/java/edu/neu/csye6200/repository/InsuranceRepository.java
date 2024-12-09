package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    // Add custom query methods as needed, for example:
    Optional<Insurance> findByPatientId(int patientId);
}
