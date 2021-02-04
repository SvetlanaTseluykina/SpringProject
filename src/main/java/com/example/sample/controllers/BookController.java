package com.example.sample.controllers;

import com.example.sample.entities.Book;
import com.example.sample.entities.User;
import com.example.sample.repositories.BookRepository;
import com.example.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/sample")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add/book")
    public @ResponseBody
    String addNewBook(@RequestParam String name, @RequestParam String publishing) {
        Book book = new Book();
        book.setBook_name(name);
        book.setPublishing(publishing);
        bookRepository.save(book);
        return "Book is saved";
    }

    @GetMapping(path = "/all/books")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
