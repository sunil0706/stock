/**
 * 
 */
package com.visel.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visel.bookstore.model.Author;

/**
 * @author sunilnayak
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
