package com.example.sample.controllers;

import com.example.sample.entities.Book;
import com.example.sample.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/sample")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/add/book")
    public Mono<String> addNewBook(@RequestParam String name, @RequestParam String publishing) {
        return bookService.addNewBook(name, publishing);
    }

    @GetMapping(path = "/all/books")
    public Mono<Iterable<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }
}
