/**
 * 
 */
package com.exsgi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author SUNIL NAYAK
 *
 */
@Controller
@ControllerAdvice
public class StoreExceptionController {
	@ExceptionHandler(value = StoreNotfoundException.class)
	   public ResponseEntity<Object> storeException(StoreNotfoundException exception) {
	      return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = ToyNotfoundException.class)
	   public ResponseEntity<Object> toyException(ToyNotfoundException exception) {
	      return new ResponseEntity<>("Toy not found", HttpStatus.NOT_FOUND);
	   }
}
