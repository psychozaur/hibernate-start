package service;


import org.hibernate.TransientObjectException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import workshop.spring5.persistence.hibernate.config.MainConfig;
import workshop.spring5.persistence.hibernate.model.Author;
import workshop.spring5.persistence.hibernate.model.Book;
import workshop.spring5.persistence.hibernate.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void shouldSaveAuthor() {
        // Given
        int authorsInDb = authorService.list().size();
        Author toSave = createAuthorWithBook(authorsInDb + 1);

        // When
        authorService.save(toSave);

        // Then
        assertEquals(authorsInDb + 1, authorService.list().size());

    }

    @Test
    public void shouldNotFindAuthor() {
        // Given
        long nonExistingId = 21321323L;
        int authorsInDb = authorService.list().size();
        Author toSave = createAuthorWithBook(authorsInDb + 1);
        authorService.save(toSave);

        // When
        Author maybeFound = authorService.findById(nonExistingId);

        // Then
        assertNull(maybeFound);

    }

    @Test
    public void shouldFindAuthor() {
        // Given
        int authorsInDb = authorService.list().size();
        Author toSave = createAuthorWithBook(authorsInDb + 1);
        long existingId = authorService.save(toSave);

        // When
        Author maybeFound = authorService.findById(existingId);

        // Then
        assertNotNull(maybeFound);

    }

    @Test
    public void shouldListAllAfterSave() {
        // Given
        int listSize = authorService.list().size();
        int maxSize = 3;

        for (int i = listSize; i < (listSize + maxSize); i++){
            Author toSave = createAuthorWithBook(i + 1);
            authorService.save(toSave);
        }

        // When
        int afterSaveListSize = authorService.list().size();

        // Then
        assertEquals(listSize + maxSize, afterSaveListSize);
    }

    @Test
    public void shouldUpdateAuthor() {
        // Given
        int authorsInDb = authorService.list().size();
        Author author = createAuthorWithBook(authorsInDb + 1);
        long savedId = authorService.save(author);

        // When
        author.setLastName("Fiszkun");
        authorService.update(author);

        // Then
        assertEquals(author.getLastName(),authorService.findById(savedId).getLastName());

    }

    @Test (expected = TransientObjectException.class)
    public void shouldThrowExceptionForUpdateWithNonExistingAuthor() {
        // Given
        int authorsInDb = authorService.list().size();
        Author author = createAuthorWithBook(authorsInDb + 1);
        long savedId = authorService.save(author);

        // When
        authorService.update(new Author("Marcypiusz","Fiszkun", null));

        // Then

    }

    @Test
    public void shouldDeleteAuthor() {
        // Given
        int authorsInDb = authorService.list().size();
        Author author = createAuthorWithBook(authorsInDb + 1);
        long savedId = authorService.save(author);

        // When
        authorService.deleteById(savedId);

        // Then
        assertNull(authorService.findById(savedId));

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForDeleteWithNonExistingId() {
        // Given
        long nonExistingId = 543543590809L;
        int authorsInDb = authorService.list().size();
        Author author = createAuthorWithBook(authorsInDb + 1);
        long savedId = authorService.save(author);

        // When
        authorService.deleteById(nonExistingId);

        // Then
        assertNull(authorService.findById(savedId));

    }

    // ============================================= helper methods ==============================================//
    private Author createAuthorWithBook(int authorNumber) {
        Author author = new Author("Author_name_" + authorNumber, "Author_lastName_" + authorNumber, null);
        Book book = new Book("Tytuł_" + authorNumber, "ISBN_" + authorNumber, author);
        List<Book> books = new ArrayList<>();
        books.add(book);
        author.setBooks(books);
        return author;
    }

}