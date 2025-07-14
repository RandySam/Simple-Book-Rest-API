package com.randy.simple_restful_api.controller;

import com.randy.simple_restful_api.dto.BookCreateRequestDTO;
import com.randy.simple_restful_api.dto.BookListResponseDTO;
import com.randy.simple_restful_api.dto.BookResponseDetailDTO;
import com.randy.simple_restful_api.dto.BookUpdateRequestDTO;
import com.randy.simple_restful_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BookController
{
    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookResponseDetailDTO> findBookDetail(@PathVariable("bookId") Long bookId)
    {
        BookResponseDetailDTO dto = bookService.findBookDetail(bookId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> createANewBook(@RequestBody BookCreateRequestDTO dto) throws URISyntaxException {
        bookService.createNewBook(dto);
        return ResponseEntity.created(new URI("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookListResponseDTO>> findBookAll(@RequestParam(value = "title", required = false)String title)
    {
        List<BookListResponseDTO> dtos = bookService.findBookAll(title);
        return ResponseEntity.ok().body(dtos);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId,
                                           @RequestBody BookUpdateRequestDTO dto)
    {
        bookService.updateBook(bookId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId)
    {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
