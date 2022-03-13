package com.colin.aop.aop;

import java.util.Date;

public class Logger {
    public static void info(String message){
        System.out.println(new Date() + ":  " + message);
    }
}
