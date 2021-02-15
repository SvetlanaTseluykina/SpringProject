package com.example.sample.services;

import com.example.sample.entities.Book;
import com.example.sample.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Mono<String> addNewBook(String name, String publishing) {
        Book book = new Book();
        book.setBook_name(name);
        book.setPublishing(publishing);
        bookRepository.save(book);
        if (log.isDebugEnabled()) {
            log.debug("book is saved");
        }
        return Mono.just("Book is saved");
    }

    public Mono<Iterable<Book>> getAllBooks() {
        return Mono.just(bookRepository.findAll());
    }
}
