package com.bib;


import java.util.List;

import javax.annotation.PostConstruct;

import com.bib.model.Author;
import com.bib.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthorServices {
    
    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public List<Author> findAllAuthors(){
   
        return authorRepository.findAll();
    }
	
		
}
