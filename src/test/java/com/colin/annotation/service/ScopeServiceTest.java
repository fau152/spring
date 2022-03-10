package com.colin.annotation.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeServiceTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");

    @Test
    public void test(){
        ScopeService scopeService1 = ac.getBean("scopeService", ScopeService.class);
        System.out.println(scopeService1.hashCode());
        ScopeService scopeService2 = ac.getBean("scopeService", ScopeService.class);
        System.out.println(scopeService2.hashCode());
    }
}