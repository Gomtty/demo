package com.myoi.controller;

import com.myoi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author myoi
 * @date 2021/9/9 - 10:05
 */
@Controller
public class BookServlet {
    @Autowired
    private BookService bookService;

    public void doget() {
        bookService.save();
    }
}
