package com.CovidShark.Controller;

import com.CovidShark.AdministrativeStaff;
import com.CovidShark.service.AdministrativeStaffService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

public class AdministrativeStaffController {
    @GetMapping("/getAdministrativeStaffDetails")
    public AdministrativeStaff getAdministrativeStaff(@RequestHeader AdministrativeStaff staff)throws InterruptedException, ExecutionException {

        return AdministrativeStaffService.getAdministrativeStaff(staff);
    }

    @PostMapping("/createAdministrativeStaff")
    public String postAdministrativeStaff(@RequestBody AdministrativeStaff staff)throws InterruptedException, ExecutionException{
        return AdministrativeStaffService.saveAdministrativeStaff(staff);
    }

    @PutMapping("/updateAdministrativeStaff")
    public String putAdministrativeStaff(@RequestBody AdministrativeStaff staff) throws ExecutionException, InterruptedException {
        return AdministrativeStaffService.updateAdministrativeStaff(staff);
    }

    @DeleteMapping("/deleteAdministrativeStaff")
    public String deleteAdministrativeStaff(@RequestHeader AdministrativeStaff staff)throws InterruptedException, ExecutionException{
        return AdministrativeStaffService.deleteAdministrativeStaff(staff);
    }
}
