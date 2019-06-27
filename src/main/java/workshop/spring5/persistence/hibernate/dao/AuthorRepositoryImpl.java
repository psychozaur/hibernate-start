package workshop.spring5.persistence.hibernate.dao;

import workshop.spring5.persistence.hibernate.model.Author;

import java.util.List;

/*
    TODO 25
    Analogicznie jak BookRepositoryImpl
    Adnotacje dla  repozytorium, serwisu, klasy z testami.
    Po kolei, dla każdej metody z repo:
    metoda z repo, serwisu, test.
 */
public class AuthorRepositoryImpl implements AuthorRepository {
    public long save(Author book) {
        return 0;
    }

    public Author findById(long id) {
        return null;
    }

    public List<Author> list() {
        return null;
    }

    public void update(Author book) {

    }

    public void deleteById(long id) {

    }
}
