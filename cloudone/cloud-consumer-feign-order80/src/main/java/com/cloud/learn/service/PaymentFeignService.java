package com.cloud.learn.service;

import com.cloud.learn.dao.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

    @GetMapping(value="books/insert")
    public Object create(@RequestBody Books books);

    @GetMapping(value="books/getById/{id}")
    public Object getById(@PathVariable("id") Integer id);

    @GetMapping(value="books/getAll")
    public Object getAll();
}
