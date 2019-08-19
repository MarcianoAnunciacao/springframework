package com.spring5.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastNMame;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastNMame) {
        this.firstName = firstName;
        this.lastNMame = lastNMame;
    }

    public Author(){}

    public Author(String firstName, String lastNMame, Set<Book> books){
        this.firstName = firstName;
        this.lastNMame = lastNMame;
        this.books = books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNMame() {
        return lastNMame;
    }

    public void setLastNMame(String lastNMame) {
        this.lastNMame = lastNMame;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != null ? !id.equals(author.id) : author.id != null) return false;
        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
        if (lastNMame != null ? !lastNMame.equals(author.lastNMame) : author.lastNMame != null) return false;
        return books != null ? books.equals(author.books) : author.books == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastNMame != null ? lastNMame.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNMame='" + lastNMame + '\'' +
                ", books=" + books +
                '}';
    }
}
