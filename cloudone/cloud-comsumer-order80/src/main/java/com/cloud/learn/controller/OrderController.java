package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://127.0.0.1:8001";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("insert")
    public Object create(@RequestBody Books books){
        return restTemplate.postForObject(PAYMENT_URL+"/books/insert",books,Object.class);
    }

    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/books/getById/"+id,Object.class);
    }

    @GetMapping("/getAll")
    public Object getAll(){
        return restTemplate.getForObject(PAYMENT_URL+"/books/getAll",Object.class);
    }

}
