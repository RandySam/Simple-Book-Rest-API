package com.randy.simple_restful_api.repository;

import com.randy.simple_restful_api.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>
{

}
