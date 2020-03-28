package com.example.springdatabooks.services;

import com.example.springdatabooks.entities.Author;
import com.example.springdatabooks.entities.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> getAllBooksAfter2000();
    List<Book> getAllBooksBefore1990();
    List<Book> getAllBooksByAuthor();
    List<Book> getAllBooksByAgeRestriction(String ageRestriction);
    List<Book> getAllBooksByEditionTypeAndCopies(String editionType, int copies);
    List<Book> getAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal priceLess, BigDecimal priceGreater);
    List<Book> getAllBooksByReleaseDateNotInYear(int year);
    List<Book> getAllBooksByReleaseDate(String date);
    List<Book> getAllBooksByTitleContains(String titleContains);
    List<Book> getAllBooksByAuthorIn(List<Author> authors);
    List<Book> getAllBooksByTitleGreaterThan(int number);
    List<Book> getAllBooksByTitle(String title);
    int getTotalCopiesByAuthor(String fullName);
    int updateBooksCopiesAfterDate(String date, int copies);
}
