package com.ozeeesoftware.bookstore.service;

import com.ozeeesoftware.bookstore.model.Book;
import com.ozeeesoftware.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;


    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Book> getBookById(long id) {
        return new ResponseEntity<Book>(bookRepository.findById(id).orElseThrow(null),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Book> createBook(Book book) {
        return new ResponseEntity<Book>(bookRepository.save(book),HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<Book> updateBook(Book book) {

        Book existingBook=bookRepository.findById(book.getId()).orElseThrow(null);

        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());

        return new ResponseEntity<Book>(bookRepository.save(existingBook),HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteBookById(long id) {
        Book existingBook=bookRepository.findById(id).orElseThrow(null);

        bookRepository.deleteById(id);

        return new ResponseEntity(existingBook,HttpStatus.OK);
    }
}
