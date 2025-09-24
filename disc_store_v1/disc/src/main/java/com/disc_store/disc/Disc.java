package com.disc_store.disc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discs")
public class Disc {

	@Id
    @GeneratedValue
    private Long id;

    private String name;
    private String author;
    private String genre;
    private Double price;

    // Constructors
    public Disc() {}

    public Disc(String name, String author, String genre, Double price) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}