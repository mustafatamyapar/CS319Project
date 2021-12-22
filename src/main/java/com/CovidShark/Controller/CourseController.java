package com.CovidShark.Controller;

import com.CovidShark.BaseUser;
import com.CovidShark.Course;
import com.CovidShark.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


public class CourseController {
    @GetMapping("/getCourseDetails")
    public Course getCourse(@RequestHeader String courceCode)throws InterruptedException, ExecutionException {

        return CourseService.getCourseDetails(courceCode);
    }

    @PostMapping("/createCourse")
    public String postCourse(@RequestBody Course aCourse)throws InterruptedException, ExecutionException{
        return CourseService.saveCourseDetails(aCourse);
    }

    @PutMapping("/updateCourse")
    public String putCourse(@RequestBody Course aCourse) throws ExecutionException, InterruptedException {
        return CourseService.updateCourseDetails(aCourse);
    }

    @DeleteMapping("/deleteCourse")
    public String deleteCourse(@RequestHeader String courceCode)throws InterruptedException, ExecutionException{
        return CourseService.deleteCourse(courceCode);
    }
}
