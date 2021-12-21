package com.CovidShark.Controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController()
public class SignupController {


    public boolean signup(){
        return true;
    }

    public boolean login(){
        return true;
    }

    @RequestMapping()
    public String hello() {

        return "Hello CovidShark" ;
    }

}
