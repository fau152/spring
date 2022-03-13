package com.colin.aop.proxy;

public class Transaction {
    public void openTransaction(){
        System.out.println("开启事务");
    }

    public void comitTransaction(){
        System.out.println("提交事务");
    }
}
