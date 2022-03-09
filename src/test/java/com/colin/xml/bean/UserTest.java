package com.colin.xml.bean;

import com.colin.xml.bean.User;
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

    @Test
    public void testSetterDI(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        User user = ac.getBean("userSetterDI",User.class);
        System.out.println(user);
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        User user1 = ac.getBean("userConstructor1", User.class);
        User user2 = ac.getBean("userConstructor2", User.class);
        User user3 = ac.getBean("userConstructor3", User.class);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
    }
}
