package com.eduboooks.test.repositories;


import com.eduboooks.test.domain.Book;
import com.eduboooks.test.domain.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ISBN entity.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



}

