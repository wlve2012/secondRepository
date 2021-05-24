package com.cloud.learn.controller;

import com.cloud.learn.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("StreamMessage")
public class SendMessageController {
    @Autowired
    private MessageProvider provider;

    @GetMapping("/sendMessage")
    public Message sendMessage(){
        return provider.send();
    }
}
