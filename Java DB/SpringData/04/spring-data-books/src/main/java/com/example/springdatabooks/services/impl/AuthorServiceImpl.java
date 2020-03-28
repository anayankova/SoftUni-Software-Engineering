package com.example.springdatabooks.services.impl;

import com.example.springdatabooks.constants.GlobalConstants;
import com.example.springdatabooks.entities.Author;
import com.example.springdatabooks.repositories.AuthorRepository;
import com.example.springdatabooks.services.AuthorService;
import com.example.springdatabooks.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(this.authorRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+");
            Author author = new Author(params[0], params[1]);
            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(this.getAllAuthorsCount()) + 1;
        return this.findAuthorById((long) randomId);
    }

    @Override
    public List<Author> getAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> getAuthorByFirstNameEndsWith(String endsWith) {
        return this.authorRepository.findAllByFirstNameEndsWith(endsWith);
    }

    @Override
    public List<Author> getAuthorByLastNameStartsWith(String startsWith) {
        return this.authorRepository.findAllByLastNameStartsWith(startsWith);
    }
}
