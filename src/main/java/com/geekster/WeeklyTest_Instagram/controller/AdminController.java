package com.geekster.WeeklyTest_Instagram.controller;

import com.geekster.WeeklyTest_Instagram.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PutMapping(value = "/user/{id}/{blue}")
    public String updatebluetick(@PathVariable Long id,@PathVariable boolean blue){
       return adminService.updatebluetick(id,blue);
    }
}
