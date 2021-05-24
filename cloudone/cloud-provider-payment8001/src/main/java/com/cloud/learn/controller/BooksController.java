package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import com.cloud.learn.serviceImpl.BooksServiceImpl;
import com.cloud.learn.serviceImpl.MessageServer;
import com.cloud.learn.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksServiceImpl service;
    @Autowired
    private MessageServer messageServer;

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

    @GetMapping("fixServer")
    public CommonResult fixServer(){
        String s = service.fixServer();
        return new CommonResult(200,"修复服务",s);
    }
    @GetMapping("sendMessage/{message}")
    public CommonResult send_message(@PathVariable("message") String message){
        try {
            messageServer.send_message(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"发送成功",null);
    }

    @GetMapping("receiveMessage")
    public CommonResult receive_message(){
        try {
            messageServer.receive_message();
            messageServer.receive_message2();
            messageServer.receive_message3();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"发送成功",null);
    }

}
