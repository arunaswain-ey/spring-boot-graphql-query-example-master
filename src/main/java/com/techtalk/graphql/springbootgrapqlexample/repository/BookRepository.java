package com.techtalk.graphql.springbootgrapqlexample.repository;

import com.techtalk.graphql.springbootgrapqlexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
