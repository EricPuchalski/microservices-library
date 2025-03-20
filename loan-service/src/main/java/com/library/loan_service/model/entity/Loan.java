package com.library.loan_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;       // ID del libro prestado
    private Long customerId;   // ID del cliente que toma prestado
    private LocalDateTime loanDate; // Fecha del préstamo
    private LocalDateTime expectedReturnDate; // Fecha de devolución esperada
    private LocalDate actualReturnDate; // Fecha de devolución real

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", customerId=" + customerId +
                ", loanDate=" + loanDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}
