package com.cloud.learn.serviceImpl;

import com.cloud.learn.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {
    @Override
    @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public Message<String> send() {
        String serial = UUID.randomUUID().toString();
        System.out.println(serial);
        return MessageBuilder.withPayload(serial).build();
    }
}
