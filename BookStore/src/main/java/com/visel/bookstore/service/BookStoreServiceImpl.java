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

import com.visel.bookstore.model.AuthorModel;
import com.visel.bookstore.model.Book;
import com.visel.bookstore.model.BookModel;
import com.visel.bookstore.model.Bookstore;
import com.visel.bookstore.repository.AuthorRepository;
import com.visel.bookstore.repository.BookStoreRepository;

/**
 * @author sunilnayak
 *
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {

	private static Logger logger = LoggerFactory.getLogger(BookStoreServiceImpl.class);

	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	/** Create a new Book */

	@Override
	public ResponseEntity<Object> saveBook(Book book) {

		logger.info("Inside saveBook service method...");
		Book newBook = new Book();

		if (bookStoreRepository.findByIsbn(book.getIsbn()).isPresent()) {
			return ResponseEntity.badRequest().body("The Book is already Present, Failed to save new book");
		} else {
			newBook.setCategory(book.getCategory());
			newBook.setIsbn(book.getIsbn());
			newBook.setTitle(book.getTitle());
			newBook.setYear(book.getYear());
			newBook.setPrice(book.getPrice());
			newBook.setAuthors(book.getAuthors());

			Book savedBook = bookStoreRepository.save(newBook);
			logger.info("After save : " + savedBook.toString());
			if (bookStoreRepository.findById(savedBook.getId()).isPresent())
				return ResponseEntity.ok("Book Saved Successfully");

			else
				return ResponseEntity.unprocessableEntity().body("Failed Saving Book as Specified");
		}
	}

	@Override
	public List<Book> findAllBooks() {
		logger.info("Inside findAllBooks service");
		List<Book> books = (List<Book>) bookStoreRepository.findAll();
		logger.info("Outside findAllBooks service");
		return books;
	}

	@Override
	public Optional<Book> findBookById(Long id) {
		logger.info("Inside findBookById service method");
		Optional<Book> book = bookStoreRepository.findById(id);
		logger.info("Outside findBookById service method");
		return book;
	}

	/** Update an Existing Book */

	@Transactional
	public ResponseEntity<Object> updateBookById(Book book) {
		Long id = book.getId();
		logger.info("Inside updateBookById service method...");
		if (bookStoreRepository.findById(id).isPresent()) {
			Book newBook = bookStoreRepository.findById(id).get();
			newBook.setCategory(book.getCategory());
			newBook.setIsbn(book.getIsbn());
			newBook.setTitle(book.getTitle());
			newBook.setYear(book.getYear());
			newBook.setPrice(book.getPrice());
			newBook.setAuthors(book.getAuthors());

			Book savedBook = bookStoreRepository.save(newBook);
			if (bookStoreRepository.findById(savedBook.getId()).isPresent())
				return ResponseEntity.ok().body("Book updated successfully");

			else
				return ResponseEntity.unprocessableEntity().body("Failed updating the book specified");

		} else
			return ResponseEntity.unprocessableEntity().body("Cannot find the book specified");
	}

	/** Delete a Book */

	public ResponseEntity<Object> deleteBook(Long id) {
		logger.info("Inside deleteBook service...");
		String authorName = authorRepository.findAuthorNameByID(id);
		
		List<Book> bookList = bookStoreRepository.findAll();
		for(Book book : bookList) {
			if(book.getAuthors().get(0).getName().equals(authorName))
			{
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Book");
			}
		}
		if (bookStoreRepository.findById(id).isPresent()) {
			bookStoreRepository.deleteById(id);
			if (bookStoreRepository.findById(id).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Book");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified book");
		} else
			return ResponseEntity.badRequest().body("Cannot find the book specified");
	}
	
	public List<Book> searchByTitle(String keyword) {
		if(keyword!=null) {
			return bookStoreRepository.findBySearchTerm(keyword);
		}
		else 
			return bookStoreRepository.findAll();
	}
	
	public BookModel getBook(Long id) {
        if(bookStoreRepository.findById(id).isPresent()) {
            Book book = bookStoreRepository.findById(id).get();
            
            BookModel bookModel = new BookModel();
            bookModel.setTitle(book.getCategory());
            bookModel.setIsbn(book.getIsbn());
            bookModel.setCategory(book.getCategory());
            bookModel.setYear(book.getYear());
            bookModel.setPrice(book.getPrice());
            bookModel.setAuthors(getAuthorList(book));
            
            return bookModel;
            
        } else 
        	return null;
    }
    public List<BookModel > getBooks() {
        List<Book> bookList = bookStoreRepository.findAll();
        if(bookList.size()>0) {
            List<BookModel> bookModels = new ArrayList<>();
            for (Book book : bookList) {
            	
            	BookModel bookModel = new BookModel();
            	bookModel.setId(book.getId());
                bookModel.setTitle(book.getTitle());
                bookModel.setIsbn(book.getIsbn());
                bookModel.setCategory(book.getCategory());
                bookModel.setYear(book.getYear());
                bookModel.setPrice(book.getPrice());                
                bookModel.setAuthors(getAuthorList(book));
                bookModels.add(bookModel);
            }
            return bookModels;
        } else 
        	return new ArrayList<BookModel>();
    }
    
    private List<AuthorModel> getAuthorList(Book book){
        List<AuthorModel> authorList = new ArrayList<>();
        for(int i=0; i< book.getAuthors().size(); i++) {
        	AuthorModel authorModel = new AuthorModel();
        	authorModel.setName(book.getAuthors().get(i).getName());
            authorList.add(authorModel);
        }
        return authorList;
    }

	@Override
	public ResponseEntity<Object> saveXMLObject(Bookstore bookstore) {
		
		return null;
	}
    
}
