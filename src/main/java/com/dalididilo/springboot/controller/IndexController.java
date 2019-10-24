package com.dalididilo.springboot.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","大离弟弟咯");

        return "index.jsp";
    }


    @RequestMapping("/user/add")
    public String add(){
        return "add.jsp";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "update.jsp";
    }

    @RequestMapping("/user/toLogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("login.jsp");
        model.addObject("ctx", request.getServletContext().getContextPath());
        return model;
    }

    @RequestMapping("/user/Login")
    public String Login(String name,String password,Model model){
        /**
         * 编写Shiro的逻辑认证
         */

//        1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        try {
            subject.login(token);
            // 不报错 说明登录成功了
            return "redirect:index";
        }catch (UnknownAccountException ex){
            // 登录失败，用户名不存在。
            model.addAttribute("msg","用户名不存在");
            return "user/Login";
        }catch (IncorrectCredentialsException ex2){
            model.addAttribute("msg","密码错误");
            return "user/Login";
        }
    }
}
