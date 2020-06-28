/**
 * 
 */
package com.visel.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visel.bookstore.model.Author;
import com.visel.bookstore.model.Book;
import com.visel.bookstore.repository.AuthorRepository;
import com.visel.bookstore.repository.BookStoreRepository;

/**
 * @author sunilnayak
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	private static Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Autowired
	private BookStoreRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	/** Create a new author */
	
	@Transactional
	public ResponseEntity<Object> saveAuthor(Author author) {

		logger.info("Inside saveAuthor service...");
		Author newAuthor = new Author();
		newAuthor.setName(author.getName());

		List<Author> authorList = new ArrayList<>();
		authorList.add(newAuthor);

		for (int i = 0; i < author.getBooks().size(); i++) {
			if (!bookRepository.findByIsbn(author.getBooks().get(i).getIsbn()).isPresent()) {
				Book newBook = author.getBooks().get(i);
				newBook.setAuthors(authorList);
				Book savedBook = bookRepository.save(newBook);
				if (!bookRepository.findById(savedBook.getId()).isPresent())
					return ResponseEntity.unprocessableEntity().body("Author Creation Failed");
			} else
				return ResponseEntity.unprocessableEntity().body("Book with isbn is already Present");
		}
		logger.info("Outside saveAuthor service...");
		return ResponseEntity.unprocessableEntity().body("Failed to Create specified Author");
	}

	@Override
	public List<Author> findAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		authors.forEach(System.out::println);
		return authors;
	}

	@Override
	public Optional<Author> findAuthorById(Long id) {
		logger.info("Inside findAuthorById service method");
		Optional<Author> author = authorRepository.findById(id);
		logger.info("Outside findAuthorById service method");
		return author;
	}

	/** Update an Existing an Author */
	@Override
	public ResponseEntity<Object> updateAuthorById(Author author, Long id) {
		if (authorRepository.findById(id).isPresent()) {
			Author newAuthor = authorRepository.findById(id).get();
			newAuthor.setName(author.getName());
			Author savedAuthor = authorRepository.save(newAuthor);
			if (authorRepository.findById(savedAuthor.getId()).isPresent())
				return ResponseEntity.accepted().body("Author saved successfully");
			else
				return ResponseEntity.badRequest().body("Failed to update author");

		} else
			return ResponseEntity.unprocessableEntity().body("Specified author not found");
	}

	/** Delete an Author */
	@Override
	public ResponseEntity<Object> deleteAuthor(Long id) {
		
		logger.info("Inside deleteAuthor service...");
		if (authorRepository.findById(id).isPresent()) {
			if (authorRepository.getOne(id).getBooks().size() == 0) {
				authorRepository.deleteById(id);
				if (authorRepository.findById(id).isPresent()) {
					return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
				} else

					return ResponseEntity.ok().body("Successfully deleted specified record");
			} else

				return ResponseEntity.unprocessableEntity()
						.body("Failed to delete,  Please delete the book associated with this author");
		} else
			logger.info("Outside deleteAuthor service...");
		return ResponseEntity.unprocessableEntity().body("No Records Found");
	}
}
