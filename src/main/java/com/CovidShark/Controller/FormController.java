package com.CovidShark.Controller;

import com.CovidShark.HealthCenterStaff;
import com.CovidShark.service.FormService;
import com.CovidShark.service.HealthCenterStaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping
public class FormController {

     @GetMapping("/getFormDate")
     public String getFormDate(@RequestHeader String id )throws InterruptedException, ExecutionException {
       return FormService.getFormDate(id);
      }

}
