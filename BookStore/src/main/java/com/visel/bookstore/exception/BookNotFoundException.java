/**
 * 
 */
package com.visel.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sunilnayak
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	 
    public BookNotFoundException(String message) {
        super(message);
    }
}
