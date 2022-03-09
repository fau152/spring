package com.colin.xml.dao.impl;

import com.colin.xml.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void selectUser() {
        System.out.println("dao selectUser");
    }
}
