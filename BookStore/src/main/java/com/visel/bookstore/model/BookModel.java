/**
 * 
 */
package com.visel.bookstore.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author sunilnayak
 *
 */

public class BookModel {
	
	private Long id;
	private String lang;
	private Integer isbn;
	private String category;
	private String title;
	private Integer year;
	private Double price;
	
	
	private List<AuthorModel> authors;

	public List<AuthorModel> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorModel> authors) {
		this.authors = authors;
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
	@XmlElement
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


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
}