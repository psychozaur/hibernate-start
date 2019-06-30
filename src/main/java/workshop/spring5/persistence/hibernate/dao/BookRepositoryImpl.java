package workshop.spring5.persistence.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

/*
    TODO 14 oznacz klasę jako komponent Spring'a (repozytorium)
 */

@Repository
public class BookRepositoryImpl implements BookRepository {
    /*
        TODO 15 wstrzyknij org.hibernate.SessionFactory
        W implementacjach poniżyszch metod, zapisywanie i pobieranie z bazy będzie
        wywoływane na obiekcie Session, pobranego za pomocą sessionFactory.getCurrentSession()
     */

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Book book) {
        /*
            TODO 18 użyj metody save
         */
        Long id = (Long) sessionFactory.getCurrentSession().save(book);

        return id;
    }

    public Book get(Long id) {
        /*
          TODO 20 użyj metody get
          Zaimplementuj metodę w serwisie
          Napisz test mmetody serwisowej
        */
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public List<Book> list() {
        /*
            TODO 21 użyj metody createQuery
            Zaimplementuj metodę w serwisie
            Napisz test mmetody serwisowej
         */
        return sessionFactory.getCurrentSession().createQuery("from Book").list();
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
