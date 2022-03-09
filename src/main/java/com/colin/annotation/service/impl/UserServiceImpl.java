package com.colin.annotation.service.impl;

import com.colin.annotation.dao.UserDao;
import com.colin.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void selectUserById() {
        userDao.selectUserById();
    }
}
