package com.colin.annotation.controller;

import com.colin.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    void login(){
        userService.selectUserById();
    }
}
