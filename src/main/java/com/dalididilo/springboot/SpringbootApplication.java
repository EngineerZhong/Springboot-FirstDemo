package com.dalididilo.springboot;

import com.dalididilo.springboot.index.controller.bean.ApplicationBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan({"com.dalididilo.springboot.index.dao","com.dalididilo.springboot.module.*.dao"})
@EnableConfigurationProperties({ApplicationBean.class})
public class SpringbootApplication {

//    常规使用RequestMapping进行请求访问。
//    @RequestMapping("/")
//    public String index(){
//        return "Hello SpringBoot";
//    }

//    properties文件引用变量
//    @Value("${com.dalididilo.name}")
//    private String name;
//    @Value("${com.dalididilo.hello}")
//    private String hello;
//
//    @RequestMapping(value="/",produces = "application/json; charset=utf-8")
//    public String hello(){
//        return name + " " + hello;
//    }

//    把properties中的常量赋值给bean，添加@EnableConfigurationProperties
    @Autowired
    ApplicationBean bean;

//    @Autowired
//    private EmpDao empDao;


    @RequestMapping(value = "/")
    public String hello(){
//        return bean.getName() + " : " + bean.getHello();
//        return empDao.getEmpById(10001).toString();
        return "index";
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
