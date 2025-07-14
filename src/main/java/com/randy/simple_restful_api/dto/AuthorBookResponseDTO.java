package com.randy.simple_restful_api.dto;

public class AuthorBookResponseDTO
{
    public String bookName;
    private String description;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
