package com.colin.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyComponetTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("Annotation.xml");
    MyComponet myComponet = ac.getBean("abc", MyComponet.class);

    @Test
    public void test(){
        myComponet.method();
    }
}