package com.randy.simple_restful_api.service;

import com.randy.simple_restful_api.dto.AuthorBookResponseDTO;
import com.randy.simple_restful_api.dto.AuthorCreateRequestDTO;

import java.util.List;

public interface AuthorService
{
    public void createNewAuthor(AuthorCreateRequestDTO dto);
    public List<AuthorBookResponseDTO> findAuthorBook(Long authorId);
}
