package service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import workshop.spring5.persistence.hibernate.config.MainConfig;
import workshop.spring5.persistence.hibernate.model.Author;
import workshop.spring5.persistence.hibernate.model.Book;
import workshop.spring5.persistence.hibernate.service.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/*
    TODO 13 adnotacje dla testowej klasy
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration wskazuje na klasę konfiguracyjną projektu
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void shouldSaveABook() {
        /*
            TODO 20 napisz test dla metody save z BookService
            Upewnij się, że została uruchomiona baza postgres.
            Uruchom test.
         */
        // Given
        int booksInDb = bookService.list().size();
        Book book = createBookWithAuthor(booksInDb + 1);

        // When
        bookService.save(book);

        // Then
        assertEquals(booksInDb + 1, bookService.list().size());

    }

    @Test
    public void shouldNotFindABook() {
        // Given
        long nonExistingId = 1223213232L;

        // When
        Book result = bookService.findById(nonExistingId);

        // Then
        assertNull(result);

    }

    @Test
    public void shouldFindABook() {
        // Given
        int nextId = bookService.list().size() + 1;
        bookService.save(createBookWithAuthor(nextId));

        // When
        Book result = bookService.findById(nextId);

        // Then
        assertNotNull(result);

    }

    @Test
    public void shouldListAllAfterSave() {
        // Given
        int nextId = bookService.list().size() + 1;
        bookService.save(createBookWithAuthor(nextId));
        List<Book> fromLoop = new ArrayList<>();
        for (int i = 1; i <= nextId; i++){
            fromLoop.add(bookService.findById(i));
        }

        // When
        List<Book> results = bookService.list();

        // Then
        System.out.println("fromLoop: " + fromLoop.toString() + ", results: " + results.toString());
        assertEquals(fromLoop.get(0), results.get(0));

    }

    @Test
    public void shouldUpdateBook() {
        // Given

        // When

        // Then

    }

    @Test
    public void shouldDeleteBook() {
        // Given

        // When

        // Then

    }
    /*
        TODO 24 zaimplementuj poniższe testy (update i delete dla nieistniejącej encji / id)
     */
    @Test
    public void shouldThrowExceptionForUpdateWithNonExistingBook() {
        // Given

        // When

        // Then

    }

    @Test
    public void shoulddThrowExceptionForDeleteWithNonExistingId() {
        // Given

        // When

        // Then

    }

    // ============================================= helper methods ==============================================//
    private Book createBookWithAuthor(int bookNumber) {
        Author author = new Author("Author_name_"+bookNumber, "Author_lastName_"+bookNumber, null);
        Book book = new Book("Tytuł_"+bookNumber, "ISBN_"+bookNumber, author);
        List<Book> books = new ArrayList<>();
        books.add(book);
        author.setBooks(books);
        return book;
    }
}