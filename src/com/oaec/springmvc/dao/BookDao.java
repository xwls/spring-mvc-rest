package com.oaec.springmvc.dao;

import com.oaec.springmvc.entity.Book;

import java.util.List;

public interface BookDao {
    int doInsert(Book book);
    int doDelete(Integer bookId);
    int doUpdate(Book book);
    List<Book> queryAll();
    Book queryById(Integer bookId);
}
