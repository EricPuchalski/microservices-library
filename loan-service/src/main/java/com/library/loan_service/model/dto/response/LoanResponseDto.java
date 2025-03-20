package com.library.loan_service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDto {
    private Long id;
    private Long bookId;
    private Long customerId;
    private LocalDateTime loanDate;
    private LocalDateTime expectedReturnDate;
    private LocalDate actualReturnDate;;
}
