package com.example.springdatabooks.services.impl;

import com.example.springdatabooks.constants.GlobalConstants;
import com.example.springdatabooks.entities.*;
import com.example.springdatabooks.repositories.BookRepository;
import com.example.springdatabooks.services.AuthorService;
import com.example.springdatabooks.services.BookService;
import com.example.springdatabooks.services.CategoryService;
import com.example.springdatabooks.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if(this.bookRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+");
            Author author = this.authorService.getRandomAuthor();
            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = this.getTitle(params);
            Set<Category> categories = this.categoryService.getRandomCategories();
            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);
            this.bookRepository.saveAndFlush(book);
        });
    }

    @Override
    public List<Book> getAllBooksAfter2000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> getAllBooksBefore1990() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/1990", formatter);
        return this.bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> getAllBooksByAuthor() {
        String firstName = "George";
        String lastName = "Powell";
        return this.bookRepository.findBooksByAuthor(firstName, lastName);
    }

    @Override
    public List<Book> getAllBooksByAgeRestriction(String ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));
    }

    @Override
    public List<Book> getAllBooksByEditionTypeAndCopies(String editionType, int copies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(
                EditionType.valueOf(editionType.toUpperCase()), copies
        );
    }

    @Override
    public List<Book> getAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal priceLess, BigDecimal priceGreater) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(priceLess, priceGreater);
    }

    @Override
    public List<Book> getAllBooksByReleaseDateNotInYear(int year) {
        LocalDate before = LocalDate.of(year, 1, 1);
        LocalDate after = LocalDate.of(year, 12, 31);
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after);
    }

    @Override
    public List<Book> getAllBooksByReleaseDate(String date) {
        LocalDate releaseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> getAllBooksByTitleContains(String titleContains) {
        return this.bookRepository.findAllByTitleContains(titleContains);
    }

    @Override
    public List<Book> getAllBooksByAuthorIn(List<Author> authors) {
        return this.bookRepository.findAllByAuthorIn(authors);
    }

    @Override
    public List<Book> getAllBooksByTitleGreaterThan(int number) {
        return this.bookRepository.findAllByTitleGreaterThan(generateRandomStringByGivenNumber(number));
    }

    @Override
    public List<Book> getAllBooksByTitle(String title) {
        return this.bookRepository.findAllByTitle(title);
    }

    @NonNull
    private String generateRandomStringByGivenNumber(int number) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + ".!?' -Ã¨()Â";
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < number; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    @Override
    public int getTotalCopiesByAuthor(String fullName) {
        return this.bookRepository.findAllCopiesByAuthor(fullName);
    }

    @Override
    public int updateBooksCopiesAfterDate(String date, int copies) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));
        return this.bookRepository.updateAllBooksAfterGivenDate(localDate, copies);
    }

    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i < params.length; i++) {
            sb.append(params[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
