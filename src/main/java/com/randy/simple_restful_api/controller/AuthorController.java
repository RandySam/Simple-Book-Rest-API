package com.randy.simple_restful_api.controller;

import com.randy.simple_restful_api.dto.AuthorBookResponseDTO;
import com.randy.simple_restful_api.dto.AuthorCreateRequestDTO;
import com.randy.simple_restful_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/v1/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody AuthorCreateRequestDTO dto) throws URISyntaxException
    {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(new URI("v1/author")).build();
    }

    @GetMapping("/author/{authorid}/book")
    public ResponseEntity<List<AuthorBookResponseDTO>> findAuthorBook(@PathVariable Long authorId) {

        List<AuthorBookResponseDTO> result = authorService.findAuthorBook(authorId);

        return ResponseEntity.ok().body(result);
    }


}
