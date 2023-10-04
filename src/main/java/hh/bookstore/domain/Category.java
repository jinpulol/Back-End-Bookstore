package hh.bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Book> books;

    // constructors
    public Category() {
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    // getters and setters
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // toString
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }
}
