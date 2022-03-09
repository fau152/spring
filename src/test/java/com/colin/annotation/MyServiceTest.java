package com.colin.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyServiceTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");

    @Test
    public void test(){
        MyService myService = ac.getBean("myService", MyService.class);
        myService.myComponet.method();
    }
}