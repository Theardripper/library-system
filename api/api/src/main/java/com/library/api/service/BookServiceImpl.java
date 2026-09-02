package com.library.api.service;

import com.library.api.dto.Response.BookResponseDTO;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookResponseDTO create(BookResponseDTO dto){
        Book book = new Book();
        book.setName(dto.getName());

    }

}
