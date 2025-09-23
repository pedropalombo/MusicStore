package com.disc_store.disc;

import java.math.BigDecimal;

public class DiscDTO {

	private Long id;
	
	private String name;
	private String author;
	private String genre;
	
	private BigDecimal price;

	// empty constructor to be used by Spring
	public DiscDTO() {
	}

	// -- Auto-generated constructor, getters/setters, and toString() --
	public DiscDTO(Long id, String name, String author, String genre, BigDecimal price) {
		this.id = id;
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