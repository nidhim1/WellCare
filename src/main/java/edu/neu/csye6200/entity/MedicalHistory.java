package edu.neu.csye6200.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicalhistory")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;


    @Column(name = "patient_id", nullable = true)
    private Long patientId;

    @Column(name = "allergies", columnDefinition = "TEXT", nullable = true)
    private String allergies;

    @Column(name = "past_diseases", columnDefinition = "TEXT", nullable = true)
    private String pastDiseases;

    @Column(name = "ongoing_medication", columnDefinition = "TEXT", nullable = true)
    private String ongoingMedication;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "doctor_notes", columnDefinition = "TEXT", nullable = true)
    private String doctorNotes;

    @Column(name = "allergy_type", length = 50, nullable = true)
    private String allergyType;

    @Column(name = "severity_of_allergy", length = 20, nullable = true)
    private String severityOfAllergy;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "medication_changes", columnDefinition = "TEXT", nullable = true)
    private String medicationChanges;

    @Column(name = "patient_notes", columnDefinition = "TEXT", nullable = true)
    private String patientNotes;

    @Column(name = "history_status", length = 50, nullable = true)
    private String historyStatus;

    // Getters and Setters

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPastDiseases() {
        return pastDiseases;
    }

    public void setPastDiseases(String pastDiseases) {
        this.pastDiseases = pastDiseases;
    }

    public String getOngoingMedication() {
        return ongoingMedication;
    }

    public void setOngoingMedication(String ongoingMedication) {
        this.ongoingMedication = ongoingMedication;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public String getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(String allergyType) {
        this.allergyType = allergyType;
    }

    public String getSeverityOfAllergy() {
        return severityOfAllergy;
    }

    public void setSeverityOfAllergy(String severityOfAllergy) {
        this.severityOfAllergy = severityOfAllergy;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getMedicationChanges() {
        return medicationChanges;
    }

    public void setMedicationChanges(String medicationChanges) {
        this.medicationChanges = medicationChanges;
    }

    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }

    public String getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(String historyStatus) {
        this.historyStatus = historyStatus;
    }

    public void setActive(boolean active) {
    }
}
