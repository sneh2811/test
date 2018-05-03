package com.eduboooks.test.repositories;


import com.eduboooks.test.domain.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the ISBN entity.
 */
@Repository
public interface ISBNRepository extends JpaRepository<ISBN, Long> {



}

