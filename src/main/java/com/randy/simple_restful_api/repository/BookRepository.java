package com.randy.simple_restful_api.repository;

import com.randy.simple_restful_api.domain.Author;
import com.randy.simple_restful_api.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleLike(String title);
    List<Book> findAllByAuthor(Author author);
}
