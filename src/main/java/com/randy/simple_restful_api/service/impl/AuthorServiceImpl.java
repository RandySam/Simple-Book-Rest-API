package com.randy.simple_restful_api.service.impl;

import com.randy.simple_restful_api.domain.Author;
import com.randy.simple_restful_api.domain.Book;
import com.randy.simple_restful_api.dto.AuthorBookResponseDTO;
import com.randy.simple_restful_api.dto.AuthorCreateRequestDTO;
import com.randy.simple_restful_api.exception.ResourceNotFoundException;
import com.randy.simple_restful_api.repository.AuthorRepository;
import com.randy.simple_restful_api.repository.BookRepository;
import com.randy.simple_restful_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createNewAuthor(AuthorCreateRequestDTO dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);

    }

    @Override
    public List<AuthorBookResponseDTO> findAuthorBook(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()->new ResourceNotFoundException("Invalid author id"));
        List<Book> books= bookRepository.findAllByAuthor(author);
       return books.stream().map((b)->{
            AuthorBookResponseDTO dto = new AuthorBookResponseDTO();
            dto.setBookName(b.getTitle());
            dto.setDescription(b.getDescription());
            return dto;
        }).collect(Collectors.toList());

    }



}
