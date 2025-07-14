package com.randy.simple_restful_api.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.randy.simple_restful_api.domain.Author;
import com.randy.simple_restful_api.domain.Book;
import com.randy.simple_restful_api.dto.BookCreateRequestDTO;
import com.randy.simple_restful_api.dto.BookListResponseDTO;
import com.randy.simple_restful_api.dto.BookResponseDetailDTO;
import com.randy.simple_restful_api.dto.BookUpdateRequestDTO;
import com.randy.simple_restful_api.exception.ResourceNotFoundException;
import com.randy.simple_restful_api.repository.AuthorRepository;
import com.randy.simple_restful_api.repository.BookRepository;
import com.randy.simple_restful_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;



    @Override
    public List<BookListResponseDTO> findBookAll(String title) {

        title = ObjectUtils.isEmpty(title)?"%":"%"+title+"%";

        List<Book> bookResponse = bookRepository.findAllByTitleLike(title);

        return bookResponse.stream().map((b)-> {
            BookListResponseDTO dto = new BookListResponseDTO();
            dto.setTitle(b.getTitle());
            dto.setAuthor(b.getAuthor().getName());
            dto.setId(b.getAuthor().getId());
            dto.setId(b.getId());
            dto.setDescription(b.getDescription());
            return dto;
        }).collect(Collectors.toList()) ;
    }

    @Override
    public void createNewBook(BookCreateRequestDTO dto) {

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Author ID"));
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        bookRepository.save(book);
    }

    @Override
    public BookResponseDetailDTO findBookDetail(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new ResourceNotFoundException("Buku tidak ditemukan"));
        BookResponseDetailDTO dto = new BookResponseDetailDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setAuthor(book.getAuthor().getName());
        dto.setDescription(book.getDescription());
        return dto;
    }

    @Override
    public void updateBook(Long bookId, BookUpdateRequestDTO dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Author ID"));

        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new ResourceNotFoundException("Buku tidak ditemukan"));
        book.setTitle(book.getTitle());
        book.setAuthor(author);
        book.setDescription(book.getDescription());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
