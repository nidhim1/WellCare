package edu.neu.csye6200.controller;

import edu.neu.csye6200.entity.Staff;
import edu.neu.csye6200.model.StaffDTO;
import edu.neu.csye6200.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public ResponseEntity<String> createStaff(@RequestBody StaffDTO staffDTO) {
        staffService.createStaff(staffDTO);
        return ResponseEntity.ok("Staff created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable int id, @RequestBody StaffDTO staffDTO) {
        staffService.updateStaff(id, staffDTO);
        return ResponseEntity.ok("Staff updated successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable int id) {
        StaffDTO staffDTO = staffService.getStaffById(id);
        return ResponseEntity.ok(staffDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }
}
