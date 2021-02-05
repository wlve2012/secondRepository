package com.cloud.learn.controller;

import com.cloud.learn.dao.Books;
import com.cloud.learn.serviceImpl.BooksServiceImpl;
import com.cloud.learn.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksServiceImpl service;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service:services){
            log.info("===> service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("===> " + instance.getServiceId()
                    + "\t" + instance.getHost()
                    + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return discoveryClient;
    }
}
