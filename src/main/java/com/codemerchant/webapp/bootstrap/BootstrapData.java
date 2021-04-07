package com.codemerchant.webapp.bootstrap;

import com.codemerchant.webapp.model.Author;
import com.codemerchant.webapp.model.Book;
import com.codemerchant.webapp.model.Publisher;
import com.codemerchant.webapp.repositories.AuthorRepository;
import com.codemerchant.webapp.repositories.BookRepository;
import com.codemerchant.webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    @Override
    public void run(String... args) throws Exception {

        Author ronnie = new Author("Cristiano", "Ronaldo");
        Book ronsBook = new Book("The Life Of Cristiano", "12345");

        Publisher almeidaBruno = new Publisher("Bruno Almeida", "", "Miami", "Florida", 14578);
        publisherRepository.save(almeidaBruno);

        ronnie.getBooks().add(ronsBook); //adding ronsBook to books set
        ronsBook.getAuthors().add(ronnie); //adding ronnie as an author in authors set

        ronsBook.setPublisher(almeidaBruno);
        almeidaBruno.getBooks().add(ronsBook);

        //saving to h2 db
        authorRepository.save(ronnie);
        bookRepository.save(ronsBook);
        publisherRepository.save(almeidaBruno);
        //--------------------------------------------------
        Author messi = new Author("Lionel", "Messi");
        Book leosBook = new Book("Fraud watch, The Messi story", "54321");
        //--------------------------------------------------
        Publisher guzmanJuan = new Publisher("Juan Guzman", "", "Compton", "California", 25413);
        publisherRepository.save(guzmanJuan);
        //--------------------------------------------------
        messi.getBooks().add(leosBook);
        leosBook.getAuthors().add(messi);

        leosBook.setPublisher(guzmanJuan);
        guzmanJuan.getBooks().add(leosBook);

        authorRepository.save(messi);
        bookRepository.save(leosBook);
        publisherRepository.save(guzmanJuan);
        //--------------------------------------------------
        Author rashford = new Author("Marcus", "Rashford");
        Book marcusBook = new Book("Manc Born", "124578");

        //joining the two entities (author and book together
        rashford.getBooks().add(marcusBook);
        marcusBook.getAuthors().add(rashford);
        //setting juan guzman as the author of the book
        marcusBook.setPublisher(guzmanJuan); //first setting the publisher of marcus's book
        guzmanJuan.getBooks().add(marcusBook); //telling the publisher that he's now the publisher of marcus' book

        authorRepository.save(rashford);
        bookRepository.save(marcusBook);
        publisherRepository.save(guzmanJuan);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Books published by " + guzmanJuan.getName() + ": " + guzmanJuan.getBooks().size());
        System.out.println("Books published by " + almeidaBruno.getName() + ": " + almeidaBruno.getBooks().size());

    }
}
