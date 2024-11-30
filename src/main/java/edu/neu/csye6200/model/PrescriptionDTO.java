package edu.neu.csye6200.model;

public class PrescriptionDTO {

    private Integer prescriptionId;
    private Integer patientId;
    private Integer staffId;
    private String issueDate;
    private String medication;
    private String dosage;
    private String frequency;
    private String duration;

    // Constructors
    public PrescriptionDTO() {}

    public PrescriptionDTO(Integer prescriptionId, Integer patientId, Integer staffId, String issueDate, String medication, String dosage, String frequency, String duration) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.staffId = staffId;
        this.issueDate = issueDate;
        this.medication = medication;
        this.dosage = dosage;
        this.frequency = frequency;
        this.duration = duration;
    }

    // Getters and Setters
    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
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

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
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
}
