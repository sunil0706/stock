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
import com.visel.bookstore.repository.BookStoreRepository;
import com.visel.bookstore.service.BookStoreServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookStoreApplicationTests {

	@Autowired
	private BookStoreServiceImpl bookService;
	
	@MockBean
	private BookStoreRepository bookRepository;
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	
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
		Optional<Book> bookTest = bookService.findBookById(1l);
		//assertFalse(bookTest.isPresent());
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
		//bookRepository.deleteBook(id);
		verify(bookRepository).deleteById(id);
	}

}
