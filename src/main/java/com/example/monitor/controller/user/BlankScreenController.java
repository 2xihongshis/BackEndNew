package com.example.monitor.controller.user;

import com.example.monitor.mapper.BlankScreenMapper;

import com.example.monitor.pojo.BlankScreen;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class BlankScreenController {
    @Autowired
//    private UserMapper userMapper;
//    request将所有请求映射过来，请求的类型有get post etc.
    private BlankScreenMapper blankscreenMapper;

    @GetMapping("/get/blankscreen/")
    public List<BlankScreen> getAll(){
        //null : query all infos
        return blankscreenMapper.selectList(null);
    }

    @RequestMapping(value="/upload/blankscreen/",method=POST)
    @ResponseBody
    public String addUser(@RequestBody String request) throws JsonProcessingException {
//        System.out.println(request.getClass().toString());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(request, Map.class);
        System.out.println(map.get("filename"));
        String empty_points = map.get("emptyPoints");
        String screen = map.get("screen");
        String view_point = map.get("viewPoint");
        String selector = map.get("selector");

        BlankScreen user = new BlankScreen(empty_points,screen,view_point,selector);
        blankscreenMapper.insert(user);

        return request;
    }


}

