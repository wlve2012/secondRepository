package com.cloud.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudStreamConsumer8801 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumer8801.class,args);
    }
}
