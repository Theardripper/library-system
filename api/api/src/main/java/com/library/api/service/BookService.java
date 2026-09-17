package com.library.api.service;

import com.library.api.dto.Request.BookRequestDTO;
import com.library.api.dto.Response.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO create(BookRequestDTO dto);
    BookResponseDTO findById(Long id);
    List<BookResponseDTO> findAll();
    BookResponseDTO update(Long id, BookRequestDTO dto);
    void delete(Long id);
}
