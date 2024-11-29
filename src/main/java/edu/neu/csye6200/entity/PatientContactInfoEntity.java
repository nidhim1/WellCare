package edu.neu.csye6200.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patientcontactinfo")
public class PatientContactInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    @Column(nullable = false, unique = true)
    private Long patientId;

    @Column(nullable = false, length = 15)
    private int phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

//    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;

    public Long getPatientId() {return patientId;}
    public void setPatientId(Long patientId) {this.patientId = patientId;}

    public int getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}



}
