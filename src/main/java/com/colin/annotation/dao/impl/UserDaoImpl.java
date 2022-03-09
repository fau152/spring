package com.colin.annotation.dao.impl;

import com.colin.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void selectUserById() {
        System.out.println("select user by id....");
    }
}
