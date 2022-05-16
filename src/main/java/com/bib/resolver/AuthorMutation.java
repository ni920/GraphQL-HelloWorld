package com.bib.resolver;


import java.util.Optional;

import com.bib.exception.AuthorNotFoundException;
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

    public Author updateAuthorName(Integer id, String name){
        Optional<Author> opt = authorRepository.findById(id);

        if(opt != null) {
            Author author = opt.get();
            author.setName(name);
            authorRepository.save(author);
            return author;
        }

        throw new AuthorNotFoundException("Der Author kann nicht gefunden werden", id);
        
    }

    public Author updateAuthorVorName(Integer id, String vorname){
        Optional<Author> opt = authorRepository.findById(id);

        if(opt != null) {
            Author author = opt.get();
            author.setVorname(vorname);
            authorRepository.save(author);
            return author;
        }

        throw new AuthorNotFoundException("Der Author kann nicht gefunden werden", id);
    }

    public Author updateAuthorNameAndVorName(Integer id, String name, String vorname){
        Optional<Author> opt = authorRepository.findById(id);

        if(opt != null) {
            Author author = opt.get();
            author.setVorname(vorname);
            author.setName(name);
            authorRepository.save(author);
            return author;
        }

        throw new AuthorNotFoundException("Der Author kann nicht gefunden werden", id);
    }

   

    public Boolean deleteAuthor(Integer id){
        Optional<Author> opt = authorRepository.findById(id);
        if(opt != null){
            authorRepository.deleteById(id);
            return true;
        }

        throw new AuthorNotFoundException("Der Author kann nicht gefunden werden", id);
    }
    
}
