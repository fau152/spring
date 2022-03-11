package com.colin.annotation.configuration;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StoreConfigTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(StoreConfig.class);

    @Test
    public void test(){
        //测试配置类中内容是否注入成功
        StoreService storeService = ac.getBean("storeService", StoreService.class);
        storeService.method();
        //测试storeConfig是否会放到容器中
        StoreConfig storeConfig = ac.getBean("storeConfig", StoreConfig.class);
        System.out.println(storeConfig);
    }
}