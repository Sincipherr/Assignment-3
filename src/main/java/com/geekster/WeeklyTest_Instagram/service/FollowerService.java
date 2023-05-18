package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.IFollowerRepo;
import com.geekster.WeeklyTest_Instagram.model.Follower;
import com.geekster.WeeklyTest_Instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    IFollowerRepo fr;

    public void saveFollower(User otheruser, User myuser) {
        Follower followerrecord=new Follower(null,otheruser,myuser);
        fr.save(followerrecord);
    }
}
