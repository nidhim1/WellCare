package edu.neu.csye6200.model;

public class StaffDTO {

    private int staffId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String department;
    private String phoneNumber;
    private String email;
    private boolean availability;
    private String specialization;
    private String username;
    private String password;

    public int getStaffId() {
        return staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAvailability() {
        return availability;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
