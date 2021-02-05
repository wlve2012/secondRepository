package com.cloud.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @RequestMapping(value = "/zk")
    public String paymentZk(){
        return "===> SpringCloud with zookeeper:"
                + port
                + "\t"
                + UUID.randomUUID().toString();
    }
}
