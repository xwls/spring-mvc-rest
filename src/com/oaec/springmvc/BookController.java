package com.oaec.springmvc;

import com.alibaba.fastjson.JSON;
import com.oaec.springmvc.entity.Book;
import com.oaec.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
