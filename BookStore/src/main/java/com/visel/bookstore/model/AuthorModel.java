/**
 * 
 */
package com.visel.bookstore.model;


/**
 * @author sunilnayak
 *
 */
public class AuthorModel {
	
	private int id;

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
