package com.example.monitor.controller.user;


import com.example.monitor.mapper.LongTaskMapper;
import com.example.monitor.mapper.PaintMapper;
import com.example.monitor.pojo.Paint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class PaintController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private PaintMapper paintMapper;

    @GetMapping("/get/paint/")
    public List<Paint> getAll(){
        return paintMapper.selectList(null);
    }

    @RequestMapping(value="/upload/paint/",method=POST)
    @ResponseBody

        public String addUser(@RequestBody String request) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request, Map.class);

            String url = map.get("url");
            String timestamp = map.get("timestamp");
            String browser = map.get("browser");

            String first_paint = map.get("first_paint");
            String first_content_paint = map.get("first_content_paint");
            String first_meaningful_paint = map.get("first_meaningful_paint");
            String largest_contentful_paint = map.get("largest_contentful_paint");//request.getParameter("selector");

            Paint user = new Paint(url,timestamp,browser,first_paint,first_content_paint,first_meaningful_paint,largest_contentful_paint);
            paintMapper.insert(user);

        return request;
    }


}
