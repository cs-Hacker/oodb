package com.cs.test.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private int id;
    protected String name;
    public Book book;
    public Student(int id, String name, Book book){
        this.id = id;
        this.name = name;
        this.book = book;
    }

}
