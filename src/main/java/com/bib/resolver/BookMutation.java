package com.bib.resolver;

import com.bib.model.Author;
import com.bib.model.Book;
import com.bib.repository.BookResolver;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class BookMutation implements GraphQLMutationResolver {
    private BookResolver bookResolver;

    public BookMutation(BookResolver bookResolver){
        this.bookResolver = bookResolver;
    }

    public Book newBook(String titel, Integer authorId){
        Book book = new Book();
        book.setTitel(titel);
        book.setAuthor(new Author(authorId));
        bookResolver.save(book);

        return book;
    }

}
