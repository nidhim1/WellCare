package edu.neu.csye6200.model;

import java.time.LocalDate;

public class AppointmentDTO {
    private Long appointmentId;
    private Long patientId;
    private Long staffId;
    private LocalDate appointmentDate;
    private String timeFrom;
    private String timeTo;
    private String status; // Scheduled, Completed, Canceled, etc.
    private String reason; // Reason for appointment, e.g., checkup, follow-up, etc.
    private String appointmentType; // Consultation, Follow-up, Emergency, etc.
    private String patientName;
    private String staffName;

    // Getters and Setters
    public Long getAppointmentId() { return appointmentId; }

    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public Long getPatientId() { return patientId; }

    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getStaffId() { return staffId; }

    public void setStaffId(Long staffId) { this.staffId = staffId; }

    public LocalDate getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getTimeFrom() { return timeFrom; }

    public void setTimeFrom(String timeFrom) { this.timeFrom = timeFrom; }

    public String getTimeTo() { return timeTo; }

    public void setTimeTo(String timeTo) { this.timeTo = timeTo; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

    public String getAppointmentType() { return appointmentType; }

    public void setAppointmentType(String appointmentType) { this.appointmentType = appointmentType; }

    public String getPatientName() { return patientName; }

    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getStaffName() { return staffName; }

    public void setStaffName(String staffName) { this.staffName = staffName; }
}
