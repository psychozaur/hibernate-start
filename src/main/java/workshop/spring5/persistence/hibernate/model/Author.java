package workshop.spring5.persistence.hibernate.model;

import javax.persistence.*;
import java.util.List;

/*
    TODO 12, analogicznie jak encja Book, opis poniżej
 */
@Entity
@Table(name="author")
public class Author {

    /*
        nazwa tabeli author

        pola klasy:
        id:Long
        name:String
        lastName:String
        books:List<Book>

        nazwa kolumny w tabeli, mapowanej z id - author_id

        adnotacja dla books
                        @OneToMany
                                  mappedBy - author
                                  cascade -  CascadeType.ALL

        wygeneruj konstruktor bezparametrowy, z wzystkimi parametrami, toString etc.
     */

    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String lastName, List<Book> books) {
        this.name = name;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!id.equals(author.id)) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
        return books != null ? books.equals(author.books) : author.books == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
