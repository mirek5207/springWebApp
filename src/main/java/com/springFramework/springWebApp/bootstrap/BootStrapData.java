package com.springFramework.springWebApp.bootstrap;

import com.springFramework.springWebApp.domain.Author;
import com.springFramework.springWebApp.domain.Book;
import com.springFramework.springWebApp.repositories.AuthorRepository;
import com.springFramework.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author("John","Conor");
        Book book = new Book("book","122435");
        john.getBooks().add(book);
        book.getAuthors().add(john);
        authorRepository.save(john);
        bookRepository.save(book);

        Author rod = new Author("Rod","Johnson");
        Book book2 = new Book("book2","4235445");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
    }
}
