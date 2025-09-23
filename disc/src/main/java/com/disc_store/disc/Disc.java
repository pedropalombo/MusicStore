package com.disc_store.disc;

import java.math.BigDecimal;

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
	
	private BigDecimal price;

	// Constructors
	public Disc() {
	}

	// -- Auto-generated constructor, getters/setters, and toString() --
	public Disc(String name, String author, String genre, BigDecimal price) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	// -- / --
}
