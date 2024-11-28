package edu.neu.csye6200.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private int insuranceId;

    @Column(name = "patient_id", nullable = false)
    private int patientId;

    @Column(name = "insurance_provider", length = 100, nullable = false)
    private String insuranceProvider;

    @Column(name = "insurance_number", length = 50, nullable = false, unique = true)
    private String insuranceNumber;

    @Column(name = "coverage_details", length = 500, nullable = false)
    private String coverageDetails;


    // Getters and Setters
    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }


}
