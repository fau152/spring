package com.colin.aop.aop.impl;

import com.colin.aop.aop.BlogDao;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDaoImpl implements BlogDao {
    @Override
    public void insert() throws RuntimeException {
        System.out.println("insert Blog...");
        throw new RuntimeException("发生异常");
    }

    @Override
    public void delete() {
        System.out.println("delete Blog...");
    }

    @Override
    public void update() {
        System.out.println("update Blog...");
    }

    @Override
    public void select() {
        System.out.println("select Blog...");
    }
}
