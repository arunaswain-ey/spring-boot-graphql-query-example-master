package com.techtalk.graphql.springbootgrapqlexample.service.datafetcher;

import com.techtalk.graphql.springbootgrapqlexample.model.Book;
import com.techtalk.graphql.springbootgrapqlexample.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findAll();
    }
}
