package com.colin.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Autowired.xml");
        Blog blog = ac.getBean("blog", Blog.class);
        blog.sayHello();
    }
}
