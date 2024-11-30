package edu.neu.csye6200.model;

import java.time.LocalDateTime;

public class MedicalHistoryDTO {

    private Long historyId;
    private Long patientId;
    private String allergies;
    private String pastDiseases;
    private String ongoingMedication;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String doctorNotes;
    private String allergyType;
    private String severityOfAllergy;
    private boolean isActive;
    private String medicationChanges;
    private String patientNotes;
    private String historyStatus;

    // Getters and Setters

    public Long getHistoryId() { return historyId; }

    public void setHistoryId(Long historyId) { this.historyId = historyId; }

    public Long getPatientId() { return patientId; }

    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getAllergies() { return allergies; }

    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getPastDiseases() { return pastDiseases; }

    public void setPastDiseases(String pastDiseases) { this.pastDiseases = pastDiseases; }

    public String getOngoingMedication() { return ongoingMedication; }

    public void setOngoingMedication(String ongoingMedication) { this.ongoingMedication = ongoingMedication; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getDoctorNotes() { return doctorNotes; }

    public void setDoctorNotes(String doctorNotes) { this.doctorNotes = doctorNotes; }

    public String getAllergyType() { return allergyType; }

    public void setAllergyType(String allergyType) { this.allergyType = allergyType; }

    public String getSeverityOfAllergy() { return severityOfAllergy; }

    public void setSeverityOfAllergy(String severityOfAllergy) { this.severityOfAllergy = severityOfAllergy; }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public String getMedicationChanges() { return medicationChanges; }

    public void setMedicationChanges(String medicationChanges) { this.medicationChanges = medicationChanges; }

    public String getPatientNotes() { return patientNotes; }

    public void setPatientNotes(String patientNotes) { this.patientNotes = patientNotes; }

    public String getHistoryStatus() { return historyStatus; }

    public void setHistoryStatus(String historyStatus) { this.historyStatus = historyStatus; }
}
