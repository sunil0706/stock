/**
 * 
 */
package com.visel.bookstore.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author sunilnayak
 *
 */
@JacksonXmlRootElement(localName="book")
public class Book {
	
	@JacksonXmlProperty(localName="year")
    @JsonProperty("year")
	private String year;

	@JacksonXmlProperty(localName="price")
    @JsonProperty("price")
    private String price;

	@JacksonXmlProperty(localName="isbn")
    @JsonProperty("isbn")
    private String isbn;

	@JacksonXmlProperty(localName="category", isAttribute = true)
    @JsonProperty("category")
    private String category;

	@JacksonXmlProperty(localName="title")
    @JsonProperty("title")
    private String title;

	 @JacksonXmlProperty(localName="authors")
	    @JsonProperty("authors")
    private Authors authors;

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getIsbn ()
    {
        return isbn;
    }

    public void setIsbn (String isbn)
    {
        this.isbn = isbn;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Authors getAuthors ()
    {
        return authors;
    }

    public void setAuthors (Authors authors)
    {
        this.authors = authors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [year = "+year+", price = "+price+", isbn = "+isbn+", category = "+category+", title = "+title+", authors = "+authors+"]";
    }
}