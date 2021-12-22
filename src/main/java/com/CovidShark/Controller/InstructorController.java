package com.CovidShark.Controller;

import com.CovidShark.Course;
import com.CovidShark.Instructor;
import com.CovidShark.service.CourseService;
import com.CovidShark.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping
public class InstructorController {
    @GetMapping("/getInstrucoDetails")
    public Instructor getInstructor(@RequestHeader String idNumber) throws InterruptedException, ExecutionException {

        return InstructorService.getInstructorDetails(idNumber);
    }

    @PostMapping("/createInstructor")
    public String postInstructor(@RequestBody Instructor instructor) throws InterruptedException, ExecutionException {
        return InstructorService.saveInstructorDetails(instructor);
    }

    @PutMapping("/updateInstructor")
    public String putInstructor(@RequestBody Instructor instructor) throws ExecutionException, InterruptedException {
        return InstructorService.updateInstructorDetails(instructor);
    }

    @DeleteMapping("/deleteInstructor")
    public String deleteInstructor(@RequestHeader String idnumber) throws InterruptedException, ExecutionException {
        return InstructorService.deleteInstructor(idnumber);
    }

}
