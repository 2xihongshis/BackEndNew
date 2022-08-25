package com.example.monitor.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.monitor.mapper.PvUvMapper;
import com.example.monitor.pojo.PvUv;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
                             
import static org.springframework.web.bind.annotation.RequestMethod.POST;
                                                  
@RestController
@CrossOrigin
public class PvUvController {
    @Autowired
    private PvUvMapper pvuvMapper;

    @GetMapping("/get/pv/")
    public List<PvUv> getAll(){
        //null : query all infos
        QueryWrapper<PvUv> queryWrapper= new QueryWrapper<>();
//        queryWrapper.eq

        return pvuvMapper.selectList(null);
    }

    //    @GetMapping("/user/add/{kind}/{type}/{error_type}/{url}/{message}/{filename}/{position}/{stack}/{selector}/")
//    @PostMapping("/user/login/")
    @RequestMapping(value="/upload/pv/",method=POST)
    @ResponseBody
    public String addUser(@RequestBody String request) throws JsonProcessingException {

        System.out.println("jodiqwhwquoiqw");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(request, Map.class);

        String kind = map.get("kind");
        String type = map.get("type");
        String source = map.get("source");
        String timestamp = map.get("timestamp");
        String effective_type = map.get("effective_type");
        String rtt = map.get("rtt");
        String uuid = map.get("uuid");
        String screen = map.get("screen");

        PvUv user = new PvUv(kind,type,timestamp,source,effective_type,rtt,uuid,screen);
        pvuvMapper.insert(user);

        return request;
    }

}
