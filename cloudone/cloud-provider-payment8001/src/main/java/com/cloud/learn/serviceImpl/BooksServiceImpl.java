package com.cloud.learn.serviceImpl;

import com.cloud.learn.dao.Books;
import com.cloud.learn.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private  BooksService service;

    private int time = 3000;
    @Override
    public List<Books> getAll() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return service.getAll();
    }

    @Override
    public Books getById(int id) {
        return service.getById(id);
    }

    @Override
    public void insert(Books book) {
        service.insert(book);
    }

    public String fixServer(){
        if(time==3000){
            time = 1;
        }else {
            time = 3000;
        }
        String s = "time ----- "+time;
        return s;
    }

}
