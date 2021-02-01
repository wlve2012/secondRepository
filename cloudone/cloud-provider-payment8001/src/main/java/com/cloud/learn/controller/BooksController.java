package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import com.cloud.learn.serviceImpl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksServiceImpl service;

    @GetMapping("/getAll")
    public Object getAll(){
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @PostMapping("insert")
    public void insert(@RequestBody Books books){
        service.insert(books);
    }

}
