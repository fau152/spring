package com.colin.annotation.bean.impl;

import com.colin.annotation.bean.Animal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("汪汪汪");
    }

    @Override
    public void run() {
        System.out.println("我是修勾，我在修沟");
    }
}
