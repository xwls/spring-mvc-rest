package com.oaec.springmvc;

import com.alibaba.fastjson.JSON;
import com.oaec.springmvc.entity.Book;
import com.oaec.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model){
        List<Book> books = bookService.books();
        System.out.println(JSON.toJSONString(books));
        model.addAttribute("books",books);
        return "books";
    }

    @GetMapping("/book")
    public String addForm(){
        return "form";
    }

    @GetMapping("/book/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book",book);
        return "form";
    }

    @PostMapping(value = "/book",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String save(Book book){
        boolean b = bookService.saveOrUpdate(book);
        return "{\"success\":"+b+"}";
    }

    @PutMapping(value = "/book",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Book book){
        System.out.println("put-book = " + book);
        boolean b = bookService.saveOrUpdate(book);
        return "{\"success\":"+b+"}";
    }

    @DeleteMapping(value = "/book/{id}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delete(@PathVariable Integer id){
        boolean b = bookService.delete(id);
        return "{\"success\":"+b+"}";
    }

}
