package com.example.monitor.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.monitor.mapper.ResourceErrorMapper;

import com.example.monitor.pojo.ResourceError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class ResourceErrorController {
    @Autowired
    private ResourceErrorMapper resourceerrorMapper;

    @GetMapping("/get/resourceerror/")
    public List<ResourceError> getAll(){
        QueryWrapper<ResourceError> queryWrapper= new QueryWrapper<>();

        return resourceerrorMapper.selectList(null);
    }

    @RequestMapping(value="/upload/resourceerror/",method=POST)
    @ResponseBody
    public String addUser(@RequestBody String request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(request, Map.class);
        String url = map.get("url");
        String timestamp = map.get("timestamp");
        String browser = map.get("browser");

        String file_name = map.get("file_name");
        String tag_name = map.get("tag_name");
        String trigger_timestamp = map.get("trigger_timestamp");
        String selector = map.get("selector");

        ResourceError user = new ResourceError(url,timestamp,browser,file_name,tag_name,trigger_timestamp,selector);
        resourceerrorMapper.insert(user);

        return request;
    }

}
