package com.CovidShark.Controller;

import com.CovidShark.Course;
import com.CovidShark.Gym;
import com.CovidShark.HealthCenterStaff;
import com.CovidShark.Salon;
import com.CovidShark.service.CourseService;
import com.CovidShark.service.GymService;
import com.CovidShark.service.HealthCenterStaffService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * The GymController class.
 */
@RestController
@RequestMapping

public class GymController {
    @GetMapping("/getSalon")
    public Salon getSalon(@RequestHeader String salonType)throws InterruptedException, ExecutionException {

        return GymService.getSalonDetails(salonType);
    }

    @PostMapping("/createGymSalon")
    public String postGymSalon(@RequestBody Salon salon)throws InterruptedException, ExecutionException{
        return GymService.saveSalonDetails(salon);
    }

    @PutMapping("/updateGymSalon")
    public String putGymSalon(@RequestBody Salon salon) throws ExecutionException, InterruptedException {
        return GymService.updateGymSalon(salon);
    }
}
