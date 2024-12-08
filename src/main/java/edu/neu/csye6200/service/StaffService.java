package edu.neu.csye6200.service;

import edu.neu.csye6200.model.StaffDTO;

import java.util.List;

public interface StaffService {

    void createStaff(StaffDTO staffDTO);

    StaffDTO getStaffById(int staffID);

    List<StaffDTO> getAllStaff();

    void updateStaff(int staffId, StaffDTO staffDTO);
}
