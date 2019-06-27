package workshop.spring5.persistence.hibernate.service;

import workshop.spring5.persistence.hibernate.model.Author;

import java.util.List;

public interface AuthorService {
    long save(Author book);

    Author findById(long id);

    List<Author> list();

    void update(Author book);

    void deleteById(long id);
}
