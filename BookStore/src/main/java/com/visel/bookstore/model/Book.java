package com.visel.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private Integer isbn;
	private String category;
	private String title;
	private Integer year;
	private Double price;

	@ManyToMany(targetEntity = Author.class, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
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

	/**
	 * @param id
	 * @param isbn
	 * @param category
	 * @param title
	 * @param year
	 * @param price
	 * @param authors
	 */
	public Book(Long id, Integer isbn, String category, String title, Integer year, Double price,
			List<Author> authors) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.category = category;
		this.title = title;
		this.year = year;
		this.price = price;
		this.authors = authors;
	}

	public Book() {
		super();
	}

}

//    @JoinTable(
//            name="t_user_roles",
//            joinColumns=
//                    @JoinColumn( name="user_id", referencedColumnName="id"),
//            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
//
