package com.example.goodbooks;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;



public class BookService implements BookRepository{
    private HashMap<Integer,Book> hmap = new HashMap<>();
    int uniqueBookId = 3;

    public BookService() {
        Book b1 = new Book(1,"Harry Potter","J.K.Rollings");
        Book b2 = new Book(2,"Berlin","Alic");

        hmap.put(b1.getBookId(),b1);
        hmap.put(b2.getBookId(),b2);

    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> booksCollection = hmap.values();
        return new ArrayList<>(booksCollection);
    }

    @Override
    public Book getBookById(int bookId) {
        if(hmap.get(bookId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return hmap.get(bookId);
    }

    @Override
    public Book addBook(Book book) {

        book.setBookId(uniqueBookId++);
        hmap.put(book.getBookId(),book);
        return book;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Book oldBook = hmap.get(bookId);

        if(oldBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(book.getBookName() != null){
            oldBook.setBookName(book.getBookName());
        }

        if(book.getAuthor() != null){
            oldBook.setAuthor(book.getAuthor());
        }
        return oldBook;
    }

    @Override
    public void deleteBook(int bookId) {
        Book tagetBook = hmap.get(bookId);
        if(tagetBook == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        hmap.remove(bookId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);      // best practice for better understanding
    }

}
