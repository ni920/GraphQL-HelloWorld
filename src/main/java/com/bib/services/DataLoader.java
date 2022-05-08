package com.bib.services;

import javax.annotation.PostConstruct;

import com.bib.model.Author;
import com.bib.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {
    
    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void loadDate(){
        Author author1 =  new Author("Max", "Mueller");

        authorRepository.save(author1);
    }

}
