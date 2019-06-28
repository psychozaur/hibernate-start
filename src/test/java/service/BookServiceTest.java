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

        bookService.save(new Book("VALIS","IDK",new Author("Philip","Dick", Arrays.asList(new Book()))));
    }

    public void shouldNotFindABook() {

    }

    public void shouldFindABook() {

    }

    public void shouldListAllAfterSave() {

    }

    public void shouldUpdateBook() {

    }



    public void shouldDeleteBook() {

    }
    /*
        TODO 24 zaimplementuj poniższe testy (update i delete dla nieistniejącej encji / id)
     */
    public void shouldThrowExceptionForUpdateWithNonExistingBook() {

    }

    public void shoulddThrowExceptionForDeleteWithNonExistingId() {

    }

    // ============================================= helper methods ==============================================//
//    private Book createBookWithAuthor(int bookNumber) {
//        Author author = new Author("Author_name_"+bookNumber, "Author_lastName_"+bookNumber, null);
//        Book book = new Book("Tytuł_"+bookNumber, "ISBN_"+bookNumber, author);
//        List<Book> books = new ArrayList<>();
//        books.add(book);
//        author.setBooks(books);
//        return book;
//    }
}