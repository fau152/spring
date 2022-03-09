package com.colin.xml.service.impl;

import com.colin.xml.dao.UserDao;
import com.colin.xml.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void selectUser() {
        userDao.selectUser();
    }
}
