package com.spring5.spring5webapp.bootstrap;

import com.spring5.spring5webapp.model.Author;
import com.spring5.spring5webapp.model.Book;
import com.spring5.spring5webapp.model.Publisher;
import com.spring5.spring5webapp.repositories.AuthorRepository;
import com.spring5.spring5webapp.repositories.BookRepository;
import com.spring5.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisherDDD = new Publisher("Harper Collins", "Six  Avenue");
        Book ddd = new Book("Domain Driven Design", "1234", publisherDDD);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        publisherRepository.save(publisherDDD);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisherNoEjb = new Publisher("Worx", "Ten Avenue");
        Book noEJB = new Book("J2EE Development without EJB", "26444", publisherNoEjb);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisherNoEjb);
        bookRepository.save(noEJB);


    }
}
