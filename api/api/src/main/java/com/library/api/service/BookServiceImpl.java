package com.library.api.service;

import com.library.api.dto.Request.BookRequestDTO;
import com.library.api.dto.Response.BookResponseDTO;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BookResponseDTO create(BookRequestDTO dto){
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
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id " + id));
        return toResponseDTO(book);
    }

    @Override
    public List<BookResponseDTO> findAll(){
        return bookRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO update(Long id, BookRequestDTO dto){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id " + id));

        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setYear(dto.getYear());
        book.setSynopis(dto.getSynopis());
        book.setSynopis(dto.getSynopis());

        Book updated = bookRepository.save(book);
        return toResponseDTO(updated);
    }

    public void delete(Long id){
        if (!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Livro não encontrado com id " + id);
        }
        bookRepository.deleteById(id);
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
