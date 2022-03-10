package com.colin.annotation.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceServiceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");

    @Test
    public void method() {
        ResourceService rs = ac.getBean("resourceService", ResourceService.class);
        rs.method();
    }
}