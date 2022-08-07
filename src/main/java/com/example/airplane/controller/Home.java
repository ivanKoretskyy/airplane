package com.example.airplane.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Home {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("")
    public Map<String, String> getStatus(){
        Map map = new HashMap<String, String>();
        map.put("appVersion", appVersion);
        return map;
    }
}
