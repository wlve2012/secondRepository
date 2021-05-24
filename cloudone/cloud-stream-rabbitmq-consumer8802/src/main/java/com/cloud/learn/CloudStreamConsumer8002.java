package com.cloud.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudStreamConsumer8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumer8002.class, args);
    }
}
