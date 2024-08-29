package com.example.goodreads.controller;

import org.springframework.web.bind.annotation.*;

import com.example.goodreads.model.Book;
import com.example.goodreads.service.BookH2Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
class BookController {
    @Autowired
    public BookH2Service bookService;

    @GetMapping("/books")
    public ArrayList<Book> getBooks(@RequestParam(value = "name",required = false) String name) {
        if(name == null){
            return bookService.getBooks();
        }
        else{
            return bookService.getBooksByName(name);
        }
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);

    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }
}