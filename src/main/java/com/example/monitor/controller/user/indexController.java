package com.example.monitor.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monitor/")
public class indexController {

    @RequestMapping("index/")
    public String index(){
        return "index.html";
    }
}
