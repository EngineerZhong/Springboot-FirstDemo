package com.dalididilo.springboot.module.login.dao;


import com.dalididilo.springboot.module.login.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    User findUserByName(@Param(value = "userName") String userName);
}
