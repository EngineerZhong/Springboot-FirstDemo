package com.dalididilo.springboot.module.login.service;

import com.dalididilo.springboot.module.login.bean.User;

public interface ILoginService {

    User findUserByName(String userName);
}
