package com.dalididilo.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {



    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","大离弟弟咯");

        return "index";
    }

}
