package com.ozeeesoftware.bookstore.controller;

import com.ozeeesoftware.bookstore.model.Book;
import com.ozeeesoftware.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable long id){
        return bookService.deleteBookById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public ResponseEntity<List<Book>> filterByPrice(@PathVariable int maxPrice){
        return bookService.filterByPrice(maxPrice);
    }


}
