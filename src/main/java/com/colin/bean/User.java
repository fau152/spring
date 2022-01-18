package com.colin.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class User {
    private String name;
    private Integer age;
    private String gender;

    public void sayHello(){
        System.out.println("hello");
    }
}
