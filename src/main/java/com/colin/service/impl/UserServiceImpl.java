package com.colin.service.impl;

import com.colin.dao.UserDao;
import com.colin.dao.impl.UserDaoImpl;
import com.colin.service.UserService;
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
