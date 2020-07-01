/**
 * 
 */
package com.visel.bookstore.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author sunilnayak
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "Book")
public class Bookstore implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@JacksonXmlProperty(localName="category")
    @JsonProperty("category")
	private String category;
	@JacksonXmlProperty(localName="title")
    @JsonProperty("title")
	private String title;
	@JacksonXmlProperty(localName="isbn")
    @JsonProperty("isbn")
	private Integer isbn;
	@JacksonXmlProperty(localName="year")
    @JsonProperty("year")
	private Integer year;
	@JacksonXmlProperty(localName="price")
    @JsonProperty("price")
	private Double price;
	@JacksonXmlElementWrapper(localName="authors")
    @JsonProperty("authors")
	private List<AuthorModel> authors;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the isbn
	 */
	public Integer getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the authors
	 */
	public List<AuthorModel> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<AuthorModel> authors) {
		this.authors = authors;
	}
}
