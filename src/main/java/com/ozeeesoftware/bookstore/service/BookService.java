package com.ozeeesoftware.bookstore.service;


import com.ozeeesoftware.bookstore.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity getAllBooks();
    ResponseEntity getBookById(long id);
    ResponseEntity createBook(Book book);
    ResponseEntity updateBook(Book book);
    ResponseEntity deleteBookById(long id);

}
