package com.bib.resolver;

import javax.annotation.PostConstruct;

import com.bib.model.Author;
import com.bib.repository.AuthorRepository;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;

    
    public AuthorMutation(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author newAuthor(String name, String vorname){
        Author author = new Author(name, vorname);
        this.authorRepository.save(author);
        return author;
    }
    
}
