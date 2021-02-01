package com.cloud.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private int bookid;
    private String bookname;
    private int price;
    private int remainder;
}
