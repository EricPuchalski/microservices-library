package com.library.book_service.service;

import com.library.book_service.model.dto.request.BookRequestDTO;
import com.library.book_service.model.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO create(BookRequestDTO bookRequestDTO);

    List<BookResponseDTO> findAll();

    BookResponseDTO findById(Long id);
}
