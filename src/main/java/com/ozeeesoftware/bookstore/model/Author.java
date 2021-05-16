package com.ozeeesoftware.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "author")
public class Author {

    private String firstName;

    private String lastName;

    private String nationality;

}
