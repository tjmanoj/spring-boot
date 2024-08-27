package com.example.goodreads.service;

import com.example.goodreads.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.goodreads.repository.BookRepository;
import com.example.goodreads.repository.BookJpaRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class BookJpaService implements BookRepository{

    @Autowired
    private BookJpaRepository bookRepository;
    @Override
    public ArrayList<Book> getBooks() {
        List<Book> booksList = bookRepository.findAll();
        return new ArrayList<Book>(booksList);
    }

    @Override
    public Book getBookById(int bookId) {
        try{
            Book book = bookRepository.findById(bookId).get();
            return book;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book updateBook(int bookId, Book book) {

        try{
            Book newbook = bookRepository.findById(bookId).get();
            if(newbook.getName() != null){
                newbook.setName(book.getName());
            }
            if(newbook.getImageUrl() != null){
                newbook.setImageUrl(book.getImageUrl());
            }
            bookRepository.save(newbook);
            return newbook;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteBook(int bookId) {
        try{
            bookRepository.deleteById(bookId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
