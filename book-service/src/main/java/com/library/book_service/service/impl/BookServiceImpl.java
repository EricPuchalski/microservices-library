package com.library.book_service.service.impl;

import com.library.book_service.model.dto.request.BookRequestDTO;
import com.library.book_service.model.dto.response.BookResponseDTO;
import com.library.book_service.model.entity.Book;
import com.library.book_service.repository.BookRepository;
import com.library.book_service.service.BookService;
import com.library.book_service.utils.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDTO create(BookRequestDTO bookRequestDTO) {
        // Convertir el request a Book
        Book book = bookMapper.toEntity(bookRequestDTO);

        //Crear book
        Book createdBook = bookRepository.save(book);

        // Loggear el book creado
        log.info("Book created: {}", createdBook);

        // Convertir el book a BookResponseDTO para retornarlo
        return bookMapper.toDto(createdBook);
    }

    @Override
    public List<BookResponseDTO> findAll() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(bookMapper::toDto) // Convertir cada book a BookResponseDTO
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookMapper::toDto).orElse(null);
    }

}
