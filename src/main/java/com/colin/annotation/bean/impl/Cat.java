package com.colin.annotation.bean.impl;

import com.colin.annotation.bean.Animal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("喵喵喵...");
    }

    @Override
    public void run() {
        System.out.println("猫步");
    }
}
