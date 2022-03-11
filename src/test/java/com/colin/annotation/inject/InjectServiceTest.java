package com.colin.annotation.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class InjectServiceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("Annotation.xml");

    @Test
    public void test(){
        InjectService injectService = ac.getBean("injectService", InjectService.class);
        injectService.method();
    }
}