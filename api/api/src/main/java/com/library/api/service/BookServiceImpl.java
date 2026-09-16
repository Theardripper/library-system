package com.library.api.service;

import com.library.api.dto.Response.BookResponseDTO;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        Book saved = bookRepository.save(book);
        return toResponseDTO(saved);
    }

    @Override
    public BookResponseDTO findById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Livro não encontrado com id"));
        return toResponseDTO(book);
    }

    public List<BookResponseDTO> listAll(){
        return bookRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    private BookResponseDTO toResponseDTO(Book book){
        return new BookResponseDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getYear(),
                book.getSynopis(),
                book.getEdition()
        );
    }

}
