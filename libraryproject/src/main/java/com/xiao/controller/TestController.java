package com.xiao.controller;

import com.xiao.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    @Autowired
    private ClassInfoService classService;
//    @RequestMapping("/index")
//    public String Index(){
////        classService.queryClassInfoAll();
//        System.out.println("Controller层应用...");
//        return "index";
//    }

}
