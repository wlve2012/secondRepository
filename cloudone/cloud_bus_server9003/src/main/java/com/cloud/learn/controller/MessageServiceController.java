package com.cloud.learn.controller;

import com.cloud.learn.service.MessageService;
import com.cloud.learn.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("bus")
public class MessageServiceController {
    @Autowired
    private MessageService service;

    @GetMapping("send_message/{message}")
    public CommonResult send_message(@PathVariable("message") String message){
        try {
            service.send_message(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"发送成功",null);
    }


    @GetMapping("receive_message")
    public CommonResult receive_message(){
        try {
            service.receive_message();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"接受信息",null);
    }
}
