package com.library.api.service;

import com.library.api.dto.Response.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO create(BookResponseDTO dto);
    BookResponseDTO findById(Long id);
    List<BookResponseDTO> findAll();
    BookResponseDTO update(Long id, BookResponseDTO dto);
    void delete(Long id);
}
