package com.colin.annotation.inject;

import javax.inject.Named;

@Named
public class InjectDao {
    public void select(){
        System.out.println("InjectDao...");
    }
}
