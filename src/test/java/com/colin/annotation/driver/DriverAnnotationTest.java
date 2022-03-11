package com.colin.annotation.driver;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverAnnotationTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("driver-annotation.xml");

    @Test
    public void test(){
        DriverAnnotation da = ac.getBean("driver", DriverAnnotation.class);
        System.out.println(da);
    }
}