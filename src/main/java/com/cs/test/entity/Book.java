package com.cs.test.entity;

import lombok.Data;

@Data
public class Book {
    protected String bookName;
    public Book(String bookName){
        this.bookName = bookName;
    }
}
