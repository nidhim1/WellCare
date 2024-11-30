package edu.neu.csye6200.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private Long appointmentId;
    private Long patientId;
    private Long staffId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDate;
    private String timeFrom;
    private String timeTo;
    private String status; // Scheduled, Completed, Canceled, etc.
    private String reason; // Reason for appointment, e.g., checkup, follow-up, etc.
    private String appointmentType; // Consultation, Follow-up, Emergency, etc.

    // Getters and Setters
    public Long getAppointmentId() { return appointmentId; }

    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public Long getPatientId() { return patientId; }

    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getStaffId() { return staffId; }

    public void setStaffId(Long staffId) { this.staffId = staffId; }

    public LocalDateTime getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

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
}
