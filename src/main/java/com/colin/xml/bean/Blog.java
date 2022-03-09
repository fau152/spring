package com.colin.xml.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Blog {
    private Integer id;
    private User author;

    public void sayHello(){
        author.sayHello();
    }
}
