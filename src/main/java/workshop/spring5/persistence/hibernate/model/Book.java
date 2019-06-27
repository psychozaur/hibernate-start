package workshop.spring5.persistence.hibernate.model;

/*
    TODO 6 adnotacje dla encji, klasa:
    @Entity
    @Table (nazwa tabeli - book)
 */
public class Book {
    /*
        TODO 7 pola klasy
        id:Long
        title: String
        isbn: String
        author: Author
     */
    /*
        TODO 8 adnotacje dla klucza (pole id)
        @Id
        @Column, nazwa book_id
        @GeneratedValue, strategy: GenerationType.SEQUENCE
     */
    /*
        TODO 9 adnotacja dla pola author
        @ManyToOne, cascade - CascadeType.ALL
     */
    /*
        TODO 10 konstruktory
        1. bezparametrowy
        2. title, isbn, author
     */

    /*
        TODO 11 getter'y & setter'y, equals, toString
     */
}
