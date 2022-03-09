package com.colin.xml.bean;

import com.colin.xml.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("BeanScope.xml");
        User user1 = ac.getBean("beanScope",User.class);
        User user2 = ac.getBean("beanScope",User.class);

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.hashCode() == user2.hashCode());
    }
}
