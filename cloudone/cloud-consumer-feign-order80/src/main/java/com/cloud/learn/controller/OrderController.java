package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import com.cloud.learn.service.PaymentFeignService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class OrderController {
    @Resource
    private PaymentFeignService feignService;

    @GetMapping("insert")
    public Object create(@RequestBody Books books){
        return feignService.create(books);
    }

    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable("id") Integer id){
        return feignService.getById(id);
    }

    @GetMapping("/getAll")
    public Object getAll(){
        return feignService.getAll();
    }

}
