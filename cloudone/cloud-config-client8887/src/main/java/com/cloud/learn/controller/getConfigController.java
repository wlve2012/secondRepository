package com.cloud.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config_client")
public class getConfigController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return name+" : "+port;
    }

}
