package com.sourabh.bookstore;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // get all books
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // add new book
    @PostMapping
    public Book addNewBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
