package edu.neu.csye6200.service.impl;

import edu.neu.csye6200.entity.Staff;
import edu.neu.csye6200.model.StaffDTO;
import edu.neu.csye6200.repository.StaffRepository;
import edu.neu.csye6200.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public void createStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        mapDtoToEntity(staffDTO, staff);
        staffRepository.save(staff);
    }

    @Override
    public StaffDTO getStaffById(int staffID) {
        Staff staff = staffRepository.findById(staffID).orElseThrow(() -> new RuntimeException("Staff not found"));
        return mapEntityToDto(staff);
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return staffRepository.findAll().stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateStaff(int staffId, StaffDTO staffDTO) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        // Update only non-null fields
        if (staffDTO.getFirstName() != null) {
            staff.setFirstName(staffDTO.getFirstName());
        }
        if (staffDTO.getMiddleName() != null) {
            staff.setMiddleName(staffDTO.getMiddleName());
        }
        if (staffDTO.getLastName() != null) {
            staff.setLastName(staffDTO.getLastName());
        }
        if (staffDTO.getRole() != null) {
            staff.setRole(staffDTO.getRole());
        }
        if (staffDTO.getDepartment() != null) {
            staff.setDepartment(staffDTO.getDepartment());
        }
        if (staffDTO.getPhoneNumber() != null) {
            staff.setPhoneNumber(staffDTO.getPhoneNumber());
        }
        if (staffDTO.getEmail() != null) {
            staff.setEmail(staffDTO.getEmail());
        }
        if (staffDTO.getSpecialization() != null) {
            staff.setSpecialization(staffDTO.getSpecialization());
        }
        if (staffDTO.getUsername() != null) {
            staff.setUserName(staffDTO.getUsername());
        }
        if (staffDTO.getPassword() != null) {
            staff.setPassword(staffDTO.getPassword());
        }
        // Update boolean fields
        staff.setAvailability(staffDTO.isAvailability());

        staffRepository.save(staff);
    }


    //Utility methods to map between DTO and Entity
    private void mapDtoToEntity(StaffDTO staffDTO, Staff staff) {
        staff.setFirstName(staffDTO.getFirstName());
        staff.setMiddleName(staffDTO.getMiddleName());
        staff.setLastName(staffDTO.getLastName());
        staff.setRole(staffDTO.getRole());
        staff.setDepartment(staffDTO.getDepartment());
        staff.setPhoneNumber(staffDTO.getPhoneNumber());
        staff.setEmail(staffDTO.getEmail());
        staff.setAvailability(staffDTO.isAvailability());
        staff.setSpecialization(staffDTO.getSpecialization());
        staff.setUserName(staff.getUserName());
        staff.setPassword(staffDTO.getPassword());
    }

    private StaffDTO mapEntityToDto(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setStaffId(staff.getStaffId());
        staffDTO.setFirstName(staff.getFirstName());
        staffDTO.setMiddleName(staff.getMiddleName());
        staffDTO.setLastName(staff.getLastName());
        staffDTO.setRole(staff.getRole());
        staffDTO.setDepartment(staff.getDepartment());
        staffDTO.setPhoneNumber(staff.getPhoneNumber());
        staffDTO.setEmail(staff.getEmail());
        staffDTO.setAvailability(staff.isAvailability());
        staffDTO.setSpecialization(staff.getSpecialization());
        staffDTO.setUsername(staff.getUserName());
        staffDTO.setPassword(staff.getPassword());
        return staffDTO;
    }
}
