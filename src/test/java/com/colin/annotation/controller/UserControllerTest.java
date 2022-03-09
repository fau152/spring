package com.colin.annotation.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserControllerTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
    UserController userController = ac.getBean("userController", UserController.class);

    @Test
    public void login() {
        userController.login();
    }
}