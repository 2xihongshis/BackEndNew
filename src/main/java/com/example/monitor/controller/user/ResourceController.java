package com.example.monitor.controller.user;

import com.example.monitor.mapper.BlankScreenMapper;
import com.example.monitor.mapper.ResourceMapper;
import com.example.monitor.pojo.BlankScreen;
import com.example.monitor.pojo.Resource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class ResourceController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private ResourceMapper resourceMapper;

    @GetMapping("/get/resource/")
    public List<Resource> getAll(){
        //null : query all infos
        return resourceMapper.selectList(null);
    }

    @RequestMapping(value="/upload/resource/",method=POST)
    @ResponseBody
    public String addUser(@RequestBody String request) throws JsonProcessingException {
//        System.out.println(request.getClass().toString());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(request, Map.class);
        String url = map.get("url");
        String timestamp = map.get("timestamp");
        String browser = map.get("browser");
        String path_name = map.get("path_name");
        String duration = map.get("duration");
        String encoded_body_size = map.get("encoded_body_size");
        String parse_dns_time = map.get("parse_dns_time");
        String connect_time = map.get("connect_time");
        String ttfb_time = map.get("ttfb_time");
        String response_time = map.get("response_time");

        Resource user = new Resource(url,timestamp,browser,path_name,duration,encoded_body_size,parse_dns_time,connect_time,ttfb_time,response_time);
        resourceMapper.insert(user);

        return request;
    }


}

