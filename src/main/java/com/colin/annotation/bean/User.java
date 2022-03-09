package com.colin.annotation.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
