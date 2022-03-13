package com.colin.aop.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BlogServiceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
    BlogService blogService = ac.getBean("blogService", BlogService.class);

    @Test
    public void addBlog() {
        blogService.addBlog();
    }

    @Test
    public void removeBlog() {
        blogService.removeBlog();
    }

    @Test
    public void modifyBlog() {
        blogService.modifyBlog();
    }

    @Test
    public void findBlog() {
        blogService.findBlog();
    }
}