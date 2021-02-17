package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import com.cloud.learn.serviceImpl.BooksServiceImpl;
import com.cloud.learn.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksServiceImpl service;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getAll")
    public CommonResult getAll(){
        List<Books> list =  service.getAll();
        return new CommonResult(200,"success in "+port,list);
    }

    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable("id") int id){
         Books book = service.getById(id);
        return new CommonResult(200,"success in "+port,book);
    }

    @PostMapping("insert")
    public CommonResult insert(@RequestBody Books books){
        service.insert(books);
        return new CommonResult(200,"success in "+port);
    }
    //zuo de la ji ba

}
