package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.IFollowingRepo;
import com.geekster.WeeklyTest_Instagram.model.Following;
import com.geekster.WeeklyTest_Instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    @Autowired
    IFollowingRepo fingr;


    public void savefollowing(User myuser, User otheruser) {
        Following followingrecord=new Following(null,myuser,otheruser);
        fingr.save(followingrecord);
    }
}
