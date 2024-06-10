package com.example.yourpackage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @SequenceGenerator(name = "book_sequence", sequenceName ="book_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    public Book() {}

    public Book(String name, String author, int stock, String description) {
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.description = description;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
// Getters and Setters
}
