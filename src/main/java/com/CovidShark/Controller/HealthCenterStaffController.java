package com.CovidShark.Controller;
import com.CovidShark.HealthCenterStaff;
import com.CovidShark.service.HealthCenterStaffService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping

public class HealthCenterStaffController {
    @GetMapping("/getHealthCenterStaffDetails")
    public HealthCenterStaff getHealthCenterStaff(@RequestHeader String idNumber)throws InterruptedException, ExecutionException {
        return HealthCenterStaffService.getHealthCenterStaffDetails(idNumber);
    }

    @PostMapping("/createHealthCenterStaff")
    public String postHealthCenterStaff(@RequestBody HealthCenterStaff aHCStaff)throws InterruptedException, ExecutionException{
        return HealthCenterStaffService.saveHealthCenterStaffDetails(aHCStaff);
    }

    @PutMapping("/updateHealthCenterStaff")
    public String putHealthCenterStaff(@RequestBody HealthCenterStaff aHCStaff) throws ExecutionException, InterruptedException {
        return HealthCenterStaffService.updateHealthCenterStaffDetails(aHCStaff);
    }

    @DeleteMapping("/deleteHealthCenterStaff")
    public String deleteHealthCenterStaff(@RequestHeader String idNumber)throws InterruptedException, ExecutionException{
        return HealthCenterStaffService.deleteHealthCenterStaff(idNumber);
    }
}
