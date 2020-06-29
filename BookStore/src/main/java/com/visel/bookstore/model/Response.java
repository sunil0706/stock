/**
 * 
 */
package com.visel.bookstore.model;

/**
 * @author sunilnayak
 *
 */
public class Response {
	private String message;
	private boolean status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * @param message
	 * @param status
	 */
	public Response(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public Response() {
		super();
	}

	
}
