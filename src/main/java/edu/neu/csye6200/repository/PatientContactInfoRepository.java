package edu.neu.csye6200.repository;

import edu.neu.csye6200.entity.PatientContactInfoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class PatientContactInfoRepository implements CrudRepository<PatientContactInfoEntity, Long> {
    Optional<PatientContactInfoEntity> findByPatientId(Long patientId) {
        return null;
    }

    @Override
    public <S extends PatientContactInfoEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PatientContactInfoEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PatientContactInfoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PatientContactInfoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<PatientContactInfoEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PatientContactInfoEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PatientContactInfoEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
