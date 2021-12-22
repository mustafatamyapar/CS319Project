package com.CovidShark.Controller;
import com.CovidShark.Student;
import com.CovidShark.service.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping

public class StudentController {
    @GetMapping("/getStudentDetails")
    public Student getStudent(@RequestHeader String idNumber)throws InterruptedException, ExecutionException {
        return StudentService.getStudentDetails(idNumber);
    }

    @PostMapping("/createStudent")
    public String postStudent(@RequestBody Student aStudent)throws InterruptedException, ExecutionException{
        return StudentService.saveStudentDetails(aStudent);
    }

    @PutMapping("/updateStudent")
    public String putStudent(@RequestBody Student aStudent) throws ExecutionException, InterruptedException {
        return StudentService.updateStudentDetails(aStudent);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestHeader String idNumber)throws InterruptedException, ExecutionException{
        return StudentService.deleteStudent(idNumber);
    }
}
