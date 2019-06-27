package workshop.spring5.persistence.hibernate.dao;

import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

/*
    TODO 14 oznacz klasę jako komponent Spring'a (repozytorium)
 */
public class BookRepositoryImpl implements BookRepository {
    /*
        TODO 15 wstrzyknij org.hibernate.SessionFactory
        W implementacjach poniżyszch metod, zapisywanie i pobieranie z bazy będzie
        wywoływane na obiekcie Session, pobranego za pomocą sessionFactory.getCurrentSession()
     */

    public Long save(Book book) {
        /*
            TODO 18 użyj metody save
         */
        return null;
    }

    public Book get(Long id) {
        /*
          TODO 20 użyj metody get
          Zaimplementuj metodę w serwisie
          Napisz test mmetody serwisowej
        */
        return null;
    }

    public List<Book> list() {
        /*
            TODO 21 użyj metody createQuery
            Zaimplementuj metodę w serwisie
            Napisz test mmetody serwisowej
         */
        return null;
    }

    public void update(Book book) {
        /*
            TODO 22 użyj metody update
            Zaimplementuj metodę w serwisie
            Napisz test mmetody serwisowej
         */

    }

    public void delete(Long id) {
        /*
            TODO 23 użyj session.byId(Book.class).load(id) dla pobrania encji
            i delete dla usunięcia
            Zaimplementuj metodę w serwisie
            Napisz test mmetody serwisowej
         */

    }
}
