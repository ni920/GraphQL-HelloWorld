package com.bib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "vorname")
    private String vorname;

    public Author(String name, String vorname){
        this.name = name;
        this.vorname = vorname;
        
    }

    @Override
    public String toString(){
        return "Authro{" + 
                "Id: " + id + ", " +
                "Name: " + name + ", " + 
                "Vorname: " + vorname +
                "}"; 
    }
}
