package com.colin.servlet;

import com.colin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserServlet{
    private UserService userService;

    protected void doPost(){
        userService.selectUser();
    }
}
