package edu.neu.csye6200.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
//import java.time.LocalDateTime;

@Entity
@Table (name = "appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This ensures the ID is auto-generated
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private Long staffId;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private String timeFrom;

    @Column(nullable = false)
    private String timeTo;

    @Column(nullable = false)
    private String status;

    private String reason;

    @Column(nullable = false)
    private String appointmentType;

    @Column(name = "created_at_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAtTimestamp;

    public void setCreatedAtTimestamp(Date createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }

    public Date getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

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
}