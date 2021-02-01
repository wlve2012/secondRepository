package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("insert")
    public Object create(Books books){
        return restTemplate.postForObject(PAYMENT_URL+"insert",books,Object.class);
    }

    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+"/getById/"+id,Object.class);
    }

}
