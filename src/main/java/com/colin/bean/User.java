package com.colin.bean;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private Integer age;
    private String gender;
}
