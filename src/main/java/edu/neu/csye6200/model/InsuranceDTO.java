package edu.neu.csye6200.model;


public class InsuranceDTO {
    private String insuranceNumber;
    private String insuranceType;
    private String insuranceDate;
    private String coverageDetails;
    private String insuranceProvider;


    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }
}
