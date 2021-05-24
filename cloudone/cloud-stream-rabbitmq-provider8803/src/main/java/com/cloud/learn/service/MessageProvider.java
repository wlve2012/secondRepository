package com.cloud.learn.service;

import org.springframework.messaging.Message;

public interface MessageProvider {
    Message<?> send();
}
