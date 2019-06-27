package workshop.spring5.persistence.hibernate.service;

import workshop.spring5.persistence.hibernate.model.Book;

import java.util.List;

public interface BookService {
    long save(Book book);

    Book findById(long id);

    List<Book> list();

    void update(Book book);

    void deleteById(long id);
}
