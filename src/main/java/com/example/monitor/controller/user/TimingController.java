package com.example.monitor.controller.user;

import com.example.monitor.mapper.TimingMapper;
import com.example.monitor.pojo.Timing;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class TimingController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private TimingMapper timingMapper;

    @GetMapping("/get/timing/")
    public List<Timing> getAll(){
        return timingMapper.selectList(null);
    }

    @RequestMapping(value="/upload/timing/",method=POST)
    @ResponseBody

        public String addUser(@RequestBody String request) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request, Map.class);

            String url = map.get("url");
            String timestamp = map.get("timestamp");
            String browser = map.get("browser");

            String parse_dns_time = map.get("parse_dns_time");
            String connect_time = map.get("connect_time");
            String ttfb_time = map.get("ttfb_time");
            String response_time = map.get("response_time");//request.getParameter("selector");
            String parse_dom_time = map.get("parse_dom_time");
            String dom_contentloaded_time = map.get("dom_contentloaded_time");
            String time_to_interactive = map.get("time_to_interactive");
            String load_time = map.get("load_time");
            Timing user = new Timing(url,timestamp,browser,parse_dns_time,connect_time,ttfb_time,response_time,parse_dom_time,dom_contentloaded_time,time_to_interactive,load_time);
            timingMapper.insert(user);

        return request;
    }


}
