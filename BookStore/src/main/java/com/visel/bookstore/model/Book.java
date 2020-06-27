package com.visel.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer isbn;
    private String category;
    private String title;
    private Integer year;
    private Double price;
    
    @ManyToMany(targetEntity = Author.class,cascade = CascadeType.ALL)
    private List<Author> authors;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", category=" + category + ", title=" + title + ", year=" + year
				+ ", price=" + price + ", authors=" + authors + "]";
	}
    
}


