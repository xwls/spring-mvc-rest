package com.oaec.springmvc.service.impl;

import com.oaec.springmvc.dao.BookDao;
import com.oaec.springmvc.entity.Book;
import com.oaec.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> books() {
        return bookDao.queryAll();
    }

    @Override
    public Book getBook(Integer bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public boolean saveOrUpdate(Book book) {
        int result = 0;
        if (book.getBookId() == null){
            //添加
            result = bookDao.doInsert(book);
        }else {
            //修改
            result = bookDao.doUpdate(book);
        }
        return result == 1;
    }
}
