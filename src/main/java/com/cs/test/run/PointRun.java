package com.cs.test.run;

import com.cs.pointUtil.PointUtil;
import com.cs.test.entity.Book;
import com.cs.test.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class PointRun {

    public static void main(String[] args) throws Exception {

        Book book = new Book("redis设计与实现");
        Student student = new Student(1, "张三", book);



        System.out.println(PointUtil.isNotNull("student.book.getBookName()", student));
    }

}
