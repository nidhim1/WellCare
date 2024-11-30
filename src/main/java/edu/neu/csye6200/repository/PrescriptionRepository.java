package edu.neu.csye6200.repository;


import edu.neu.csye6200.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    // JpaRepository provides CRUD methods
}
