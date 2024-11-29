package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.AppointmentEntity;
import edu.neu.csye6200.model.AppointmentDTO;
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
        return dto;
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(entity -> {
            AppointmentDTO dto = new AppointmentDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
