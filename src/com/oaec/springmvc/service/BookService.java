package com.oaec.springmvc.service;

import com.oaec.springmvc.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> books();

    Book getBook(Integer bookId);

    boolean saveOrUpdate(Book book);

    boolean delete(Integer id);

}
