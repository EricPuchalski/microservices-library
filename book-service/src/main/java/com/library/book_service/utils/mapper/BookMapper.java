package com.library.book_service.utils.mapper;

import com.library.book_service.model.dto.request.BookRequestDTO;
import com.library.book_service.model.dto.response.BookResponseDTO;
import com.library.book_service.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    // Convertir de Book a BookDto
    public  BookResponseDTO toDto(Book book) {
        if (book == null) {
            return null;
        }
        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .isbn(book.getIsbn())
                .publicationDate(book.getPublicationDate())
                .build();
    }

    // Convertir de BookDto a Book
    public  Book toEntity(BookRequestDTO bookDto) {
        if (bookDto == null) {
            return null;
        }
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .genre(bookDto.getGenre())
                .isbn(bookDto.getIsbn())
                .publicationDate(bookDto.getPublicationDate())
                .build();
    }
}
