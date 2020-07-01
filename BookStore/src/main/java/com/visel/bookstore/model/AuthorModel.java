/**
 * 
 */
package com.visel.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author sunilnayak
 *
 */
@JacksonXmlRootElement(localName="authors")
public class AuthorModel {
	
	private int id;
	@JacksonXmlProperty(localName="name")
    @JsonProperty("author")
	private String name;
	

	/**
	 * 
	 */
	public AuthorModel() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public AuthorModel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
