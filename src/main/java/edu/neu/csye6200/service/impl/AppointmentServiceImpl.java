package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.AppointmentEntity;
import edu.neu.csye6200.model.AppointmentDTO;
import edu.neu.csye6200.model.PatientInfoDTO;
import edu.neu.csye6200.model.StaffDTO;
import edu.neu.csye6200.repository.AppointmentRepository;
import edu.neu.csye6200.service.AppointmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private StaffServiceImpl staffService;

    @Autowired
    private PatientInfoImpl patientInfoService;

    @Override
    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {
        AppointmentEntity entity = new AppointmentEntity();
        BeanUtils.copyProperties(appointmentDTO, entity);
        entity = appointmentRepository.save(entity);
        BeanUtils.copyProperties(entity, appointmentDTO);
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        AppointmentEntity entity = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        AppointmentDTO dto = new AppointmentDTO();
        BeanUtils.copyProperties(entity, dto);

        // Fetch and set patient and staff names
        PatientInfoDTO patient = patientInfoService.getPatientById(Math.toIntExact(entity.getPatientId()));
        StaffDTO staff = staffService.getStaffById(Math.toIntExact(entity.getStaffId()));

        dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
        dto.setStaffName(staff.getFirstName() + " " + staff.getLastName());

        return dto;
    }


    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(entity -> {
            AppointmentDTO dto = new AppointmentDTO();
            BeanUtils.copyProperties(entity, dto);

            // Fetch and set patient and staff names
            PatientInfoDTO patient = patientInfoService.getPatientById(Math.toIntExact(entity.getPatientId()));
            StaffDTO staff = staffService.getStaffById(Math.toIntExact(entity.getStaffId()));

            dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
            dto.setStaffName(staff.getFirstName() + " " + staff.getLastName());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
        AppointmentEntity entity = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Update only non-null fields
        if (appointmentDTO.getPatientId() != null) entity.setPatientId(appointmentDTO.getPatientId());
        if (appointmentDTO.getStaffId() != null) entity.setStaffId(appointmentDTO.getStaffId());
        if (appointmentDTO.getAppointmentDate() != null) entity.setAppointmentDate(appointmentDTO.getAppointmentDate());
        if (appointmentDTO.getTimeFrom() != null) entity.setTimeFrom(appointmentDTO.getTimeFrom());
        if (appointmentDTO.getTimeTo() != null) entity.setTimeTo(appointmentDTO.getTimeTo());
        if (appointmentDTO.getStatus() != null) entity.setStatus(appointmentDTO.getStatus());
        if (appointmentDTO.getReason() != null) entity.setReason(appointmentDTO.getReason());
        if (appointmentDTO.getAppointmentType() != null) entity.setAppointmentType(appointmentDTO.getAppointmentType());

        entity = appointmentRepository.save(entity);

        AppointmentDTO updatedDTO = new AppointmentDTO();
        BeanUtils.copyProperties(entity, updatedDTO);
        return updatedDTO;
    }
}
