package com.bib.resolver;

import java.util.List;
import java.util.Optional;

import com.bib.model.Author;
import com.bib.repository.AuthorRepository;

import org.springframework.stereotype.Component;


import graphql.kickstart.tools.GraphQLQueryResolver;



@Component
public class AuthorQuery implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;

    public AuthorQuery(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Integer id){
        return authorRepository.findById(id);
    }
}
