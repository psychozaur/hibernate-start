package workshop.spring5.persistence.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring5.persistence.hibernate.dao.AuthorRepository;
import workshop.spring5.persistence.hibernate.model.Author;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public long save(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(long id) {
        return authorRepository.findById(id);
    }

    public List<Author> list() {
        return authorRepository.list();
    }

    @Transactional
    public void update(Author author) {
        authorRepository.update(author);
    }

    @Transactional
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
}
