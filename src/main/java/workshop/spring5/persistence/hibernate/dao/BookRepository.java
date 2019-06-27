package workshop.spring5.persistence.hibernate.dao;

import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

public interface BookRepository {
    Long save(Book book);

    Book get(Long id);

    List<Book> list();

    void update(Book book);

    void delete(Long id);
}
