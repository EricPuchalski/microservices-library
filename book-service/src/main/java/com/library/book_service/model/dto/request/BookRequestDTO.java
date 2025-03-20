package com.library.book_service.model.dto.request;

import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDTO {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private LocalDate publicationDate;
}
