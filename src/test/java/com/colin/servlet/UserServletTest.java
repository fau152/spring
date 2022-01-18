package com.colin.servlet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServletTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
    UserServlet userServlet = ac.getBean("userServlet", UserServlet.class);

    @Test
    public void test(){
        userServlet.doPost();
    }
}