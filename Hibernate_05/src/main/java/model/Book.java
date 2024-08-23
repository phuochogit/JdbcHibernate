package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	private String id;
	
	private String name;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	public Book() {
		super();
	}

	public Book(String id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Book(String id, String name, Double price, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
