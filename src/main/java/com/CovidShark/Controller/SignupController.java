package com.CovidShark.Controller;

import com.CovidShark.BaseUser;
import com.CovidShark.service.UserSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * The SignupController class.
 */
@RestController()
@RequestMapping
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


    @GetMapping("/getUserDetails")
    public BaseUser getBaseUser(@RequestHeader String name)throws InterruptedException, ExecutionException {

        return UserSignupService.getUserDetails(name);
    }

    @PostMapping("/createUser")
    public String postBaseUser(@RequestBody BaseUser baseUser)throws InterruptedException, ExecutionException{
        return UserSignupService.saveUserDetails(baseUser);
    }

    @PutMapping("/updateUser")
    public String putBaseUser(@RequestBody BaseUser baseUser) throws ExecutionException, InterruptedException {
        return UserSignupService.updateUserDetails(baseUser);
    }

    @DeleteMapping("/deleteUser")
    public String deleteBaseUser(@RequestHeader String name)throws InterruptedException, ExecutionException{
        return UserSignupService.deleteUser(name);
    }


}
