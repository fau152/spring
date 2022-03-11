package com.colin.xml.driver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverXmlTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("driver-xml.xml");

    @Test
    public void test(){
        DriverXml driverXml = ac.getBean("driverXml", DriverXml.class);
        System.out.println(driverXml);
    }
}