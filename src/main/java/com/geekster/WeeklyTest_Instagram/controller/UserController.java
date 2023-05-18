package com.geekster.WeeklyTest_Instagram.controller;

import com.geekster.WeeklyTest_Instagram.dto.SignInInput;
import com.geekster.WeeklyTest_Instagram.model.User;
import com.geekster.WeeklyTest_Instagram.service.AuthenticationService;
import com.geekster.WeeklyTest_Instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @Autowired
    AuthenticationService as;

    @PostMapping(value = "/signup")
    public String signup(@RequestBody User signupdto){
        return us.signup(signupdto);
    }

    @PostMapping(value = "/signin")
    public String signin(@RequestBody SignInInput signindto){
        return us.signin(signindto);
    }

    @PutMapping(value = "/update/{id}/{email}")
    public String updatedetails(@PathVariable Integer id,@PathVariable String email){
        return us.updatedetails(id,email);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;
        if(as.authenticate(email,token)) {
            as.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;
        }
        else {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }
    @PostMapping(value = "/follow/{myid}/{oid}")
    public String followuser(@PathVariable Long myid,@PathVariable Long oid){
       return us.followuser(myid,oid);
    }
}
