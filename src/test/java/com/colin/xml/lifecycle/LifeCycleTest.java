package com.colin.xml.lifecycle;

import com.colin.xml.lifecycle.LifeCycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("LifeCycle.xml");

    @Before
    public void setUp(){
        ac.start();
    }

    @After
    public void tearDown(){
        ac.close();
    }

    @Test
    public void test(){
        LifeCycle lifeCycle = ac.getBean("lifecycle", LifeCycle.class);
        System.out.println(lifeCycle.hashCode());
    }
}