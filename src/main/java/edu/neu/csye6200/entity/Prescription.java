package edu.neu.csye6200.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT behavior
    @Column(name = "prescription_id")
    private int prescriptionId;

    @Column(name = "patient_id", nullable = true)
    private Integer patientId;

    @Column(name = "staff_id", nullable = true)
    private Integer staffId;

    @Column(name = "issue_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Column(name = "medication", columnDefinition = "TEXT", nullable = true)
    private String medication;

    @Column(name = "dosage", length = 50, nullable = true)
    private String dosage;

    @Column(name = "frequency", length = 50, nullable = true)
    private String frequency;

    @Column(name = "duration", length = 50, nullable = true)
    private String duration;

    @Column(name = "created_at_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAtTimestamp;

    // Getters and Setters
    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public void setCreatedAtTimestamp(Date createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }
}

