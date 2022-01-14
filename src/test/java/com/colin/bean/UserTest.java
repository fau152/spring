package com.colin.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test1(){
    //1. 获取beanFactory, ApplicationContext是BeanFactory的子类
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
    //2. 获取对象
        //User user = (User)ac.getBean("user");
        User user = ac.getBean("user", User.class);
    //3. 使用对象
        System.out.println(user.toString());
    }
}
