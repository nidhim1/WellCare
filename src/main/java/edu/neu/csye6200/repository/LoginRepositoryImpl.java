package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.Patient;
import edu.neu.csye6200.entity.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepositoryImpl implements LoginRespository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Patient> findPatientByUsernameAndPassword(String username, String password) {
        Query query = entityManager.createQuery("SELECT p from Patient p WHERE p.userName = :username AND p.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<Staff> findStaffByUsernameAndPassword(String username, String password) {
        Query query = entityManager.createQuery("SELECT s from Staff s WHERE s.userName = :username AND s.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList().stream().findFirst();
    }
}
