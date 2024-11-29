package edu.neu.csye6200.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "patientcontactinfo")
@Getter @Setter
@NoArgsConstructor


public class PatientContactInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String patientId;
    @Column (nullable = false, unique = true)
    private int phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private int postalCode;
    private String Country;
}
