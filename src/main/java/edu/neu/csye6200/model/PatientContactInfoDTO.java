package edu.neu.csye6200.model;



public class PatientContactInfoDTO {


    private Long patientId;
    private int phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String Country;

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() { return state; }
    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() { return Country; }
    public void setCountry(String country) { this.Country = country; }
}
