package com.bib.resolver;

import java.util.Optional;

import com.bib.exception.AuthorNotFoundException;
import com.bib.model.Author;
import com.bib.model.Book;
import com.bib.repository.BookRepository;


import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class BookMutation implements GraphQLMutationResolver {
    private BookRepository bookResolver;

    public BookMutation(BookRepository bookResolver){
        this.bookResolver = bookResolver;
    }

    public Book newBook(String titel, Integer authorId){
        Book book = new Book();
        book.setTitel(titel);
        book.setAuthor(new Author(authorId));
        bookResolver.save(book);

        return book;
    }

    public Book updateBook(Integer id, String titel){
        Optional<Book> opt = bookResolver.findById(id);
        if (opt !=null){
            Book book = opt.get();
            book.setTitel(titel);
            bookResolver.save(book);
            return book;
        }

        throw new AuthorNotFoundException("Das Buch koennte nicht gefunden werden!", id);

    }

    public Boolean deleteBook(Integer id){
        Optional<Book> opt = bookResolver.findById(id);
        if (opt !=null){
            bookResolver.deleteById(id);
            return true;
        }

        throw new AuthorNotFoundException("Das Buch koennte nicht gefunden werden!", id);

    }



}
