package com.example.monitor.controller.user;


import com.example.monitor.mapper.FetchMapper;
import com.example.monitor.pojo.Fetch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class FetchController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private FetchMapper fetchMapper;

    @GetMapping("/get/fetch/")
    public List<Fetch> getAll(){
        return fetchMapper.selectList(null);
    }

    @RequestMapping(value="/upload/fetch/",method=POST)
    @ResponseBody

        public String addUser(@RequestBody String request) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request, Map.class);

            String url = map.get("url");
            String timestamp = map.get("timestamp");
            String browser = map.get("browser");

            String path_name = map.get("path_name");
            String status = map.get("status");
            String duration = map.get("duration");
            String response = map.get("response");//request.getParameter("selector");
            String params = map.get("params");
            Fetch user = new Fetch(url,timestamp,browser,path_name,status,duration,response,params);
            fetchMapper.insert(user);

        return request;
    }


}
