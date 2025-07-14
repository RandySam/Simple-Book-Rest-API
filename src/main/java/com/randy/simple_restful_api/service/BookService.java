package com.randy.simple_restful_api.service;

import com.randy.simple_restful_api.dto.BookCreateRequestDTO;
import com.randy.simple_restful_api.dto.BookListResponseDTO;
import com.randy.simple_restful_api.dto.BookResponseDetailDTO;
import com.randy.simple_restful_api.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService
{
    public List<BookListResponseDTO> findBookAll(String title);
    public void createNewBook(BookCreateRequestDTO dto);
    public BookResponseDetailDTO findBookDetail(Long bookId);
    public void updateBook(Long bookId, BookUpdateRequestDTO dto);
    public void deleteBook(Long bookId);
}
