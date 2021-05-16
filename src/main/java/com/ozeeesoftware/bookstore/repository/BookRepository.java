package com.ozeeesoftware.bookstore.repository;

import com.ozeeesoftware.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Long> {

    List<Book> findByPriceLessThan(int maxPrice);


}
