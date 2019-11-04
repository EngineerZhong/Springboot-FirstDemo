package com.dalididilo.springboot.index.controller;


import com.dalididilo.springboot.index.controller.bean.ControlDevice;
import com.dalididilo.springboot.index.service.IndexService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    IndexService indexService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name",indexService.getEmpById(10001));
//        redisTemplate.opsForValue().set("name","大离弟弟咯。");
//        Map<String,String> options = new HashMap<>();
//        options.put("01","大离");
//        options.put("02","弟弟咯");
//        redisTemplate.opsForValue().set("map",options);

        return "index";
    }


    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/user/toLogin")
    public String login(Model model,HttpServletRequest request){
//        ModelAndView model = new ModelAndView("user/login");
        model.addAttribute("ctx", request.getServletContext().getContextPath());
        return "user/login";
    }



    /**
     * 控制设备的开关
     * @param initControlDeviceJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Controller3")
    public String Controller3(@RequestBody ControlDevice initControlDeviceJson){
        System.out.println(initControlDeviceJson.toString());
        String[] result = new String[]{"{\"code\":1,\"info\":\"下发命令成功\"}"
                ,"{\"code\":0,\"info\":\"当前控制模块已经掉线\"}"
                ,"{\"code\":-1,\"info\":\"上传字段空值\"}"};
        int computer=(int)(Math.random()*3);

        System.out.println(result[computer]);

        return result[computer];

//        String requestJson = JSON.toJSONString(initControlDeviceJson); // 请求体。
//        System.out.println(requestJson);
//        Result result = new Result(true);
//        try {
//            result.setMessage(HttpTool.sendPost(requestJson,"http://112.53.82.25:9000/khcontrol/api/control/ControlDevice",""));
//            result.setStatusCode(200);
//        } catch (IOException e) {
//            e.printStackTrace();
//            result.setSuccess(false);
//            result.setStatusCode(500);
//            result.setMessage("错误" + e.getMessage());
//        }
////        System.out.println(requestJson);
//        return result;
    }


//    @RequestMapping("/user/Login")
//    public String Login(String name,String password,Model model){
//        /**
//         * 编写Shiro的逻辑认证
//         */
//
////        1、获取Subject
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//
//        return getString(model, subject, token);
//    }
}
