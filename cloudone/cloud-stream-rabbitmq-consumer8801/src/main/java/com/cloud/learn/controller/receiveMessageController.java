package com.cloud.learn.controller;

import com.cloud.learn.service.MessageReceiver;
import com.cloud.learn.serviceImpl.MessageReceiverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

@RestController
@RequestMapping("StreamMessage")
public class receiveMessageController {

/*    @Autowired
    private MessageReceiverImpl receiver;

    @GetMapping("receive")
    public void getMessage(){
       // receiver.receive();
    }*/

}
