package com.spring.activemq.controller;

import com.spring.activemq.service.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhongbing on 2018/4/10.
 */
@Controller
public class TestController {
    @Resource
    Producer producer;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,String> test(@RequestParam("test") String test)
    {
        Map<String,String> map=new HashMap<>();
        producer.sendMsg(null,test);
        map.put("name","liuhongbing");
        return  map;
    }

}
