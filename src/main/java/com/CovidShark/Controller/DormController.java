package com.CovidShark.Controller;

import com.CovidShark.Dormitory;
import com.CovidShark.HealthCenterStaff;
import com.CovidShark.service.DormService;
import com.CovidShark.service.HealthCenterStaffService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class DormController {
    @GetMapping("/getDorm")
    public Dormitory getDorm(@RequestHeader int dormNumber)throws InterruptedException, ExecutionException {
        return DormService.getDormDetails(dormNumber);
    }

    @PostMapping("/createDorm")
    public String createDorm(@RequestBody Dormitory dormitory)throws InterruptedException, ExecutionException{
        return DormService.saveDormDetails(dormitory);
    }

    @PutMapping("/updateDorm")
    public String putDorm(@RequestBody Dormitory dormitory) throws ExecutionException, InterruptedException {
        return DormService.updateDormDetails(dormitory);
    }

}
