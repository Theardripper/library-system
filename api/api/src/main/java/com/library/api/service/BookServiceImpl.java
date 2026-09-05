package com.library.api.service;

import com.library.api.dto.Response.BookResponseDTO;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDTO create(BookResponseDTO dto){
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setYear(dto.getYear());
        book.setSynopis(dto.getSynopis());
        book.setEdition(dto.getEdition());

        Book salved = bookRepository.save(book);
        return toResponseDTO(salved);

    }

}
