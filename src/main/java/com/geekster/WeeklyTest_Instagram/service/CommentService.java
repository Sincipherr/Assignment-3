package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService  {
    @Autowired
    ICommentRepo cr;
}
