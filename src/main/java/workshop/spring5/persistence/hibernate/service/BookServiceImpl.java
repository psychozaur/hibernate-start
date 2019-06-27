package workshop.spring5.persistence.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring5.persistence.hibernate.dao.BookRepository;
import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

/*
    TODO 16 oznacz klasę jako komponent Springa (serwis)
    Dodaj adnotację @Transactional(readOnly = true)
 */

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {
    /*
        TODO 17 Wstrzyknij repozytorium dla Book
        Będzie użyte w implementacjach metod.

        Metody save, update i deleteById oznacz @Transactional
     */

    BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public long save(Book book) {
        /*
            TODO 19 wywołaj metodę z repozytorium
         */
        return bookRepository.save(book);

    }

    public Book findById(long id) {
        return null;
    }

    public List<Book> list() {
        return null;
    }

    @Transactional
    public void update(Book book) {

    }

    @Transactional
    public void deleteById(long id) {

    }
}
