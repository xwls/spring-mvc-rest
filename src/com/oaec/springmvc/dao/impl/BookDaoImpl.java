package com.oaec.springmvc.dao.impl;

import com.oaec.springmvc.dao.BookDao;
import com.oaec.springmvc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int doInsert(Book book) {
        String sql = "INSERT INTO book (name, author, price) VALUES (?,?,?)";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice());
    }

    @Override
    public int doDelete(Integer bookId) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        return jdbcTemplate.update(sql,bookId);
    }

    @Override
    public int doUpdate(Book book) {
        String sql = "UPDATE book SET name = ?, author = ?, price = ? WHERE book_id = ?";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getBookId());
    }

    @Override
    public List<Book> queryAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book queryById(Integer bookId) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),bookId);
    }
}
