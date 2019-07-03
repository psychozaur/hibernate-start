package workshop.spring5.persistence.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import workshop.spring5.persistence.hibernate.model.Author;

import java.util.List;

/*
    TODO 25
    Analogicznie jak BookRepositoryImpl
    Adnotacje dla  repozytorium, serwisu, klasy z testami.
    Po kolei, dla każdej metody z repo:
    metoda z repo, serwisu, test.
 */

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long save(Author author) {
        return (Long) sessionFactory.getCurrentSession().save(author);
    }

    public Author findById(long id) {
        return sessionFactory.getCurrentSession().get(Author.class, id);
    }

    public List<Author> list() {
        return sessionFactory.getCurrentSession().createQuery("from Author").list();
    }

    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }

    public void deleteById(long id) {
        Author toDelete = sessionFactory.getCurrentSession().byId(Author.class).load(id);
        sessionFactory.getCurrentSession().delete(toDelete);
    }
}
