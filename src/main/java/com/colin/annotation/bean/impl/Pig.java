package com.colin.annotation.bean.impl;

import com.colin.annotation.bean.Animal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class Pig implements Animal {
    @Override
    public void speak() {
        System.out.println("哼哼哼");
    }

    @Override
    public void run() {
        System.out.println("猪突猛进");
    }
}
