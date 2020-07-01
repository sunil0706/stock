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
@JacksonXmlRootElement(localName="authors")
public class Authors {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName="author")
    @JsonProperty("author")
	private String[] author;

    public String[] getAuthor ()
    {
        return author;
    }

    public void setAuthor (String[] author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [author = "+author+"]";
    }
}
