package com.bib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter 
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titel")
    private String titel;

    @ManyToOne
    @JoinColumn(name = "author_id",
                nullable = false, updatable = false)
    private Author author;

    public Book(){

    }

    public Book(String titel, Author author){
        this.titel = titel;
        this.author = author;
    }

    @Override
    public String toString(){
        return "Book{" +
                "Id: " + id + ", " +
                "Titel: " + titel + ", " +
                "Author: " + author + ", " +
                "}";
    }
    
}
