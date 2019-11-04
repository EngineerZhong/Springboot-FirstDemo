package com.dalididilo.springboot.module.login.service.impl;


import com.dalididilo.springboot.module.login.bean.User;
import com.dalididilo.springboot.module.login.dao.LoginDao;
import com.dalididilo.springboot.module.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {


    @Autowired
    private LoginDao loginDao;

    @Override
    public User findUserByName(String userName) {
        return loginDao.findUserByName(userName);
    }
}
