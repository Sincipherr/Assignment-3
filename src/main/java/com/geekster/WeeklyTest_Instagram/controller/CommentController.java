package com.geekster.WeeklyTest_Instagram.controller;

import com.geekster.WeeklyTest_Instagram.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentService cs;

}
