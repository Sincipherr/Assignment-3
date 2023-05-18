package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminrepo;

    @Autowired
    UserService us;

    public String updatebluetick(Long id,boolean blue) {
       return us.updatebluetick(id,blue);
    }
}
