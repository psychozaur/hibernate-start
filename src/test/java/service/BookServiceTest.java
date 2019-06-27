package service;


import workshop.spring5.persistence.hibernate.model.Author;
import workshop.spring5.persistence.hibernate.model.Book;

import java.util.ArrayList;
import java.util.List;

/*
    TODO 13 adnotacje dla testowej klasy
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration wskazuje na klasę konfiguracyjną projektu
 */
public class BookServiceTest {


    public void shouldSaveABook() {
        /*
            TODO 20 napisz test dla metody save z BookService
            Upewnij się, że została uruchomiona baza postgres.
            Uruchom test.
         */

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