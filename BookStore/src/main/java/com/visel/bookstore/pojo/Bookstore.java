/**
 * 
 */
package com.visel.bookstore.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author sunilnayak
 *
 */
@JacksonXmlRootElement(localName="Bookstore")
public class Bookstore {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName="book")
    @JsonProperty("book")
	private Book[] book;

    public Book[] getBook ()
    {
        return book;
    }

    public void setBook (Book[] book)
    {
        this.book = book;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [book = "+book+"]";
    }
}
