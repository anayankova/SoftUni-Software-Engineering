package com.example.springdatabooks.repositories;

import com.example.springdatabooks.entities.AgeRestriction;
import com.example.springdatabooks.entities.Author;
import com.example.springdatabooks.entities.Book;
import com.example.springdatabooks.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    @Query("SELECT b FROM Book AS b " +
            "WHERE b.author.firstName =:firstName AND b.author.lastName =:lastName " +
            "ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findBooksByAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal priceLess, BigDecimal priceGreater);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContains(String titleContains);

    List<Book> findAllByAuthorIn(List<Author> authors);

    List<Book> findAllByTitleGreaterThan(String string);

    List<Book> findAllByTitle(String title);

    @Query("SELECT sum(b.copies) FROM Book AS b WHERE concat(b.author.firstName, ' ', b.author.lastName) = :name")
    int findAllCopiesByAuthor(@Param("name") String fullName);

    @Modifying
    @Query("UPDATE Book AS b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    int updateAllBooksAfterGivenDate(@Param("date") LocalDate date, @Param("copies") int copies);
}
