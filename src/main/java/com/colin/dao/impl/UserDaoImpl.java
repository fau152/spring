package com.colin.dao.impl;

import com.colin.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void selectUser() {
        System.out.println("dao selectUser");
    }
}
