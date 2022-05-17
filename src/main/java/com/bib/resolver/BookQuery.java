package com.bib.resolver;

import java.util.List;
import java.util.Optional;

import com.bib.model.Book;
import com.bib.repository.BookRepository;


import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class BookQuery implements GraphQLQueryResolver {
    private BookRepository bookRepository;

    public BookQuery(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Integer id){
        // Optional<Book> opt = bookRepository.findById(id);
        return bookRepository.findById(id);
    }
}
