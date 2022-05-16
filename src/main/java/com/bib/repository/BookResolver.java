package com.bib.repository;

import com.bib.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookResolver extends JpaRepository<Book, Integer> {
    
}
