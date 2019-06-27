package workshop.spring5.persistence.hibernate.dao;

import workshop.spring5.persistence.hibernate.model.Author;

import java.util.List;

public interface AuthorRepository {
    long save(Author book);

    Author findById(long id);

    List<Author> list();

    void update(Author book);

    void deleteById(long id);
}
