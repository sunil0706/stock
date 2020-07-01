/**
 * 
 */
package com.visel.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visel.bookstore.model.Book;
import com.visel.bookstore.model.BookModel;

/**
 * @author sunilnayak
 *
 */
@Repository
public interface BookStoreRepository extends JpaRepository<Book, Long>{
	
	@Query("select b from Book b order by id")
	public List<Book> findAll();
	
	public Optional<Book> findByIsbn(Integer id);
	
	@Query("SELECT t FROM Book t WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.category) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    public List<Book> findBySearchTerm(@Param("searchTerm") String searchTerm);
		
	
}
