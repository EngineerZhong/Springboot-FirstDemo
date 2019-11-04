package com.dalididilo.springboot.shiro;


import com.dalididilo.springboot.module.login.bean.User;
import com.dalididilo.springboot.module.login.service.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    ILoginService loginService;
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        return null;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = loginService.findUserByName(token.getUsername());
        if(user == null){
            // 用户名不存在
            return null;// shiro底层会抛出UnKnowAccountException
        }

        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
