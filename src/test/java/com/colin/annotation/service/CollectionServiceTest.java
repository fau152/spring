package com.colin.annotation.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionServiceTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");

    @Test
    public void method() {
        CollectionService cs = ac.getBean("collectionService", CollectionService.class);
        cs.method();
    }

    @Test
    public void method2(){
        CollectionService cs = new CollectionService();
        cs.method();
    }
}