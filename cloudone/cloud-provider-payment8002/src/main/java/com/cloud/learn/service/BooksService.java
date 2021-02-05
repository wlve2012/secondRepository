package com.cloud.learn.service;

import com.cloud.learn.dao.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksService {
    public List<Books> getAll();

    public Books getById(int id);

    public void insert(Books book);
}
