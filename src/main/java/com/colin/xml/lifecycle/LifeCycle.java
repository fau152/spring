package com.colin.xml.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycle implements InitializingBean, DisposableBean {
    private void start(){
        System.out.println("start method.");
    }

    private void stop(){
        System.out.println("stop method.");
    }

    private void startMethod(){
        System.out.println("beans start...");
    }

    private void destroyMethod(){
        System.out.println("beans destroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBean destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DisposableBean afterPropertiesSet...");
    }
}
