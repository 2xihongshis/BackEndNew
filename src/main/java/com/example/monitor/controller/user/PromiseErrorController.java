package com.example.monitor.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.monitor.mapper.PromiseErrorMapper;
import com.example.monitor.pojo.PromiseError;
import com.example.monitor.pojo.PvUv;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class PromiseErrorController {
    @Autowired
    private PromiseErrorMapper promiseerrorMapper;

    @GetMapping("/get/promiseerror/")
    public List<PromiseError> getAll(){
        QueryWrapper<PromiseError> queryWrapper= new QueryWrapper<>();

        return promiseerrorMapper.selectList(null);
    }


    @RequestMapping(value="/upload/promiseerror/",method=POST)
    @ResponseBody
    public String addUser(@RequestBody String request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(request, Map.class);

        String url = map.get("url");
        String timestamp = map.get("timestamp");
        String browser = map.get("browser");
        String message = map.get("message");
        String stack = map.get("stack");
        String selector = map.get("selector");

        PromiseError user = new PromiseError(url,timestamp,browser,message,stack,selector);
        promiseerrorMapper.insert(user);

        return request;
    }

}
