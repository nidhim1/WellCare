package edu.neu.csye6200.service;

import edu.neu.csye6200.model.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO getAppointmentById(Long appointmentId);
    List<AppointmentDTO> getAllAppointments();
    void deleteAppointment(Long appointmentId);
    AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO);
}
