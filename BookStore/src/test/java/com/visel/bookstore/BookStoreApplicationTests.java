package com.visel.bookstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.visel.bookstore.model.Author;
import com.visel.bookstore.model.Book;
import com.visel.bookstore.repository.AuthorRepository;
import com.visel.bookstore.repository.BookStoreRepository;
import com.visel.bookstore.service.AuthorServiceImpl;
import com.visel.bookstore.service.BookStoreServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookStoreApplicationTests {

	@Autowired
	private BookStoreServiceImpl bookService;
	
	@MockBean
	private BookStoreRepository bookRepository;
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	@MockBean
	private AuthorRepository authorRepository;
		
	
	@Test
	public void findAllBooksTest() {
		Author author = new Author();
		author.setId(3l);
		author.setName("sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		when(bookRepository.findAll()).thenReturn((List<Book>) Stream
				.of(new Book(3l, 4, "test", "testing", 2020, 2.90, list)).collect(Collectors.toList()));
		assertEquals(1, bookService.findAllBooks().size());
	}
	
	@Test
	public void findBooksByIdTest() {
		Book book = new Book();
		book.setId(1l);
		book.setIsbn(123);
		book.setCategory("Computer");
		book.setTitle("Computer Engineering");
		book.setPrice(34.56);
		List<Book> listBook = new ArrayList<>();
		listBook.add(book);
		Long id = 1l;
		Author author = new Author();
		author.setId(3l);
		author.setName("sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		when(bookService.findBookById(id)).thenReturn(Optional.of(book));
		bookService.findBookById(1l);
	}
	
	@Test
	public void saveBookTest() throws Exception {
		Author author = new Author();
		author.setId(5l);
		author.setName("Sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		Book book = new Book(4l, 888, "test", "testing", 2020, 22.90, list);
		when(bookRepository.save(book)).thenReturn(book);
		
		
	}

	@Test
	public void deleteBookByIdTest() {
		Long id = 1l;
		Author author = new Author();
		author.setId(5l);
		author.setName("Sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		Book book = new Book(4l, 888, "test", "testing", 2020, 22.90, list);
		bookRepository.deleteById(id);
		//verify(bookRepository).deleteById(id);
	}
	@Test
	public void searchBookTest() {
		Author author = new Author();
		author.setId(5l);
		author.setName("Sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		Book book = new Book(4l, 888, "web", "Learning XML", 2020, 22.90, list);
		String category = book.getCategory();
		bookRepository.findBySearchTerm(category);
		assertEquals(0, bookService.searchByTitle(category).size());
	}
	
	@Test
	public void findAllAuthorsTest() {
		Book book = new Book();
		book.setId(1l);
		book.setIsbn(123);
		book.setCategory("Computer");
		book.setTitle("Spring Boot");
		book.setYear(2010);
		book.setPrice(45.56);
		List<Book> listBook = new ArrayList<>();
		listBook.add(book);
		when(authorRepository.findAll()).thenReturn(Stream
				.of(new Author(1L, "SUNIL", listBook)).collect(Collectors.toList()));
		assertEquals(1, authorService.findAllAuthors().size());
	}
	
	@Test
	public void findAuthorByIdTest() {
		Author author = new Author();
		author.setId(3l);
		author.setName("sunil");
		
		when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
	}
	
	@Test
	public void saveAuthorTest() {
		Book book = new Book();
		book.setId(1l);
		book.setIsbn(123);
		book.setCategory("Computer");
		book.setTitle("Computer Engineering");
		book.setPrice(34.56);
		List<Book> listBook = new ArrayList<>();
		listBook.add(book);
		Author author = new Author(1l, "Sunil Kumar", listBook);
		when(authorRepository.save(author)).thenReturn(author);
	}

	@Test
	public void deleteAuthorByIdTest() {
		Long id = 4l;
		Author author = new Author();
		author.setId(5l);
		author.setName("Sunil");
		List<Author> list = new ArrayList<>();
		list.add(author);
		Book book = new Book(4l, 888, "test", "testing", 2020, 22.90, list);
		//bookService.deleteBook(id);
		//verify(bookRepository, times(1)).delete(book);
	}
}
