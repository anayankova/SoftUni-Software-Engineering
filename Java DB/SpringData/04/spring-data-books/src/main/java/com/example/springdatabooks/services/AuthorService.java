package com.example.springdatabooks.services;

import com.example.springdatabooks.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getAllAuthorsCount();
    Author findAuthorById(Long id);
    Author getRandomAuthor();
    List<Author> getAllAuthorsByCountOfBooks();
    List<Author> getAuthorByFirstNameEndsWith(String endsWith);
    List<Author> getAuthorByLastNameStartsWith(String startsWith);
}
