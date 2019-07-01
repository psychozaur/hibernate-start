package workshop.spring5.persistence.hibernate.model;

import javax.persistence.*;

/*
    TODO 6 adnotacje dla encji, klasa:
    @Entity
    @Table (nazwa tabeli - book)
 */
@Entity
@Table(name="book")
public class Book {
    /*
        TODO 7 pola klasy
        id:Long
        title: String
        isbn: String
        author: Author
     */
    private String title;
    private String isbn;
    /*
        TODO 8 adnotacje dla klucza (pole id)
        @Id
        @Column, nazwa book_id
        @GeneratedValue, strategy: GenerationType.SEQUENCE
     */
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    /*
        TODO 9 adnotacja dla pola author
        @ManyToOne, cascade - CascadeType.ALL
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;
    /*
        TODO 10 konstruktory
        1. bezparametrowy
        2. title, isbn, author
     */

    public Book() {
    }

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    /*
        TODO 11 getter'y & setter'y, equals, toString
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (!id.equals(book.id)) return false;
        return author != null ? author.equals(book.author) : book.author == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + id.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", id=" + id +
                ", author=" + author +
                '}';
    }
}
