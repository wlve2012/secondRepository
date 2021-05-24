package com.cloud.learn.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class receiveMessage  {
    @Value("${server.port}")
    private  String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println("我是消费者5号，-----》接受到的消息是："+message.getPayload()+"\t"+port);
    }
}
