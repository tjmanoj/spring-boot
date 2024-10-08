package com.example.goodbooks;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;

@RestController
public class BookController {
    BookService service = new BookService();
    @GetMapping("/books")
    public ArrayList<Book> getAllBooks(@RequestParam(value = "id", required = false) Integer id) {
        if(id == null){
            return service.getBooks();
        }
        else{
            Book book = service.getBookById(id);
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(book);
            return books;
        }
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return service.getBookById(bookId);
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book updatedBook) {
        return service.updateBook(bookId, updatedBook);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        service.deleteBook(bookId);
    }
}
