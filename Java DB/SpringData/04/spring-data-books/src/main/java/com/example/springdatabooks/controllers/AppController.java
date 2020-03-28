package com.example.springdatabooks.controllers;

import com.example.springdatabooks.entities.Book;
import com.example.springdatabooks.services.AuthorService;
import com.example.springdatabooks.services.BookService;
import com.example.springdatabooks.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.math.BigDecimal;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        //seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        // SPRING DATA INTRO

        //Ex 1
//        this.bookService.getAllBooksAfter2000()
//                .forEach(b -> System.out.printf("%s%n", b.getTitle()));

        //Ex 2
//        this.bookService.getAllBooksBefore1990()
//                .forEach(b -> System.out.printf("%s %s%n", b.getAuthor().getFirstName(),  b.getAuthor().getLastName()));

        //Ex 3
//        this.authorService.getAllAuthorsByCountOfBooks()
//                .forEach(a ->
//                        System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size())
//                );

        //Ex 4
//        this.bookService.getAllBooksByAuthor()
//                .forEach(b -> System.out.println(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies()));

        // SPRING DATA ADVANCED

        //1. Book titles by age restriction
//        System.out.println("Enter age restriction:");
//        this.bookService.getAllBooksByAgeRestriction(this.bufferedReader.readLine())
//                .stream().map(Book::getTitle).forEach(System.out::println);

        //2. Golden Books
//        this.bookService.getAllBooksByEditionTypeAndCopies("gold", 5000)
//                .stream().map(Book::getTitle).forEach(System.out::println);

        //3. Books by Price
//        this.bookService.getAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
//                .forEach(b -> System.out.printf("%s - $%.2f%n", b.getTitle(), b.getPrice()));

        //4. Not Released Books
//        System.out.println("Enter year:");
//        this.bookService.getAllBooksByReleaseDateNotInYear(Integer.parseInt(this.bufferedReader.readLine()))
//                .stream().map(Book::getTitle).forEach(System.out::println);

        //5. Books Released Before Date
//        System.out.println("Enter date:");
//        this.bookService.getAllBooksByReleaseDate(this.bufferedReader.readLine())
//                .forEach(b -> System.out.printf("%s %s %.2f%n",
//                        b.getTitle(), b.getEditionType(), b.getPrice()));

        //6. Authors Search
//        System.out.println("Enter end first name string:");
//        this.authorService.getAuthorByFirstNameEndsWith(this.bufferedReader.readLine())
//                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));

        //7. Book Search
//        System.out.println("Enter containing string in title:");
//        this.bookService.getAllBooksByTitleContains(this.bufferedReader.readLine())
//                .stream().map(Book::getTitle).forEach(System.out::println);

        //8. Book Titles Search
//        System.out.println("Enter start last name string:");
//        this.bookService.getAllBooksByAuthorIn(this.authorService.getAuthorByLastNameStartsWith(
//                this.bufferedReader.readLine()))
//                .forEach(b -> System.out.printf("%s (%s %s)%n", b.getTitle(),
//                        b.getAuthor().getFirstName(), b.getAuthor().getLastName()));

        //9. Count Books
//        System.out.println("Enter number for title longer than:");
//        System.out.println(this.bookService.getAllBooksByTitleGreaterThan(
//                Integer.parseInt(this.bufferedReader.readLine())).size());

        //10. Total Book Copies
//        System.out.println("Enter full name:");
//        System.out.println(this.bookService.getTotalCopiesByAuthor(this.bufferedReader.readLine()));

        //11. Reduced Book
//        System.out.println("Enter title:");
//        this.bookService.getAllBooksByTitle(this.bufferedReader.readLine())
//                .forEach(b -> System.out.printf("%s %s %s %.2f%n",
//                        b.getTitle(), b.getEditionType().toString(), b.getAgeRestriction().toString(), b.getPrice()));

        //12. Increase Book Copies
//        System.out.println("Enter date and copies:");
//        String date = this.bufferedReader.readLine();
//        int copies = Integer.parseInt(this.bufferedReader.readLine());
//        int totalCopies = this.bookService.updateBooksCopiesAfterDate(date, copies) * copies;
//        System.out.println(totalCopies);

    }
}
