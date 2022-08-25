package com.example.monitor.controller.user;


import com.example.monitor.mapper.LongTaskMapper;
import com.example.monitor.mapper.js_errorMapper;
import com.example.monitor.pojo.LongTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class LongTaskController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private LongTaskMapper longtaskMapper;

    @GetMapping("/get/longtask/")
    public List<LongTask> getAll(){
        return longtaskMapper.selectList(null);
    }

    @RequestMapping(value="/upload/longtask/",method=POST)
    @ResponseBody

        public String addUser(@RequestBody String request) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request, Map.class);

            String url = map.get("url");
            String timestamp = map.get("timestamp");
            String browser = map.get("browser");

            String event_type = map.get("event_type");
            String start_time = map.get("start_time");
            String duration = map.get("duration");
            String selector = map.get("selector");//request.getParameter("selector");

            LongTask user = new LongTask(url,timestamp,browser,event_type,start_time,duration,selector);
            longtaskMapper.insert(user);

        return request;
    }


}
