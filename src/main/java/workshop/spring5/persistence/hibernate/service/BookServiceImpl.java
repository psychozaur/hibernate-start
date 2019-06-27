package workshop.spring5.persistence.hibernate.service;

import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

/*
    TODO 16 oznacz klasę jako komponent Springa (serwis)
    Dodaj adnotację @Transactional(readOnly = true)
 */
public class BookServiceImpl implements BookService {
    /*
        TODO 17 Wstrzyknij repozytorium dla Book
        Będzie użyte w implementacjach metod.

        Metody save, update i deleteById oznacz @Transactional
     */
    public long save(Book book) {
        /*
            TODO 19 wywołaj metodę z repozytorium
         */
        return 0;
    }

    public Book findById(long id) {
        return null;
    }

    public List<Book> list() {
        return null;
    }

    public void update(Book book) {

    }

    public void deleteById(long id) {

    }
}
