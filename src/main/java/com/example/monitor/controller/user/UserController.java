package com.example.monitor.controller.user;


import com.example.monitor.mapper.js_errorMapper;
import com.example.monitor.pojo.js_error;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private js_errorMapper js_errorMapper;

    @GetMapping("/user/all/")
    public List<js_error> getAll(){
        //null : query all infos
        return js_errorMapper.selectList(null);
//        return userService.findAll();
    }


    @RequestMapping(value="/post/jserror/",method=POST)
    @ResponseBody

        public String addUser(@RequestBody String request) throws JsonProcessingException {
            System.out.println(request.getClass().toString());
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request, Map.class);
            System.out.println(map.get("filename"));

            String url = map.get("url");
            String timestamp = map.get("timestamp");
            String browser = map.get("browser");

            String message = map.get("message");
            String filename = map.get("filename");
            String position = map.get("position");
            String stack = map.get("stack");
            String selector = map.get("selector");//request.getParameter("selector");

            js_error user = new js_error(url,timestamp,browser,message,filename,position,stack,selector);
            js_errorMapper.insert(user);
        return request;
    }


}
