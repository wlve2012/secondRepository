package com.cloud.learn.controller;

import com.cloud.learn.service.FeignConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class FeignConsumerController {
    @Autowired
    private FeignConsumerService service;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return service.paymentInfo_OK(id);
    }

    @GetMapping("/out/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return service.paymentInfo_TimeOut(id);
    }
}
