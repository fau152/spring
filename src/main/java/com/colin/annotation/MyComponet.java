package com.colin.annotation;

import org.springframework.stereotype.Component;

@Component("abc")
public class MyComponet {
    public void method(){
        System.out.println("MyComponet...");
    }
}
