package com.techtalk.graphql.springbootgrapqlexample.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.techtalk.graphql.springbootgrapqlexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Loading Initial Data in DB");
        Stream.of(
                new Book("123", "Book of Clouds", "Kindle Edition", new String[]{ "Chloe Aridjis"}
                        , "Nov 2017"),
                new Book("124", "Cloud Arch & Engineering", "Orielly", new String[]{"Peter", "Sam"}
                        , "Jan 2015"),
                new Book("125", "Java 9 Programming", "Orielly", new String[]{"Venkat", "Ram"}
                        , "Dec 2016")
        ).forEach(book -> {
            bookRepository.save(book);
        });
        System.out.println("Data loaded, Verifying :"+bookRepository.findAll().size());
    }
}
