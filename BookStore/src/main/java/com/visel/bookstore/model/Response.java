/**
 * 
 */
package com.visel.bookstore.model;

import java.util.List;

/**
 * @author sunilnayak
 *
 */
public class Response {
	private String message;
	private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param message
	 * @param details
	 */
	public Response(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Response() {
		super();
	}

}
