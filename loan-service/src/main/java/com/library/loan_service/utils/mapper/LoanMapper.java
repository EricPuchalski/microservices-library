package com.library.loan_service.utils.mapper;

import com.library.loan_service.model.dto.request.LoanRequestDto;
import com.library.loan_service.model.dto.response.LoanResponseDto;
import com.library.loan_service.model.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan toEntity(LoanRequestDto loanRequestDto) {
        if (loanRequestDto == null){
            return null;
        }
        return Loan.builder()
                .bookId(loanRequestDto.getBookId())
                .customerId(loanRequestDto.getCustomerId())
                .build();

    }

    public LoanResponseDto toDto(Loan loan) {
        if (loan == null){
            return null;
        }
        return LoanResponseDto.builder()
                .id(loan.getId())
                .bookId(loan.getBookId())
                .customerId(loan.getCustomerId())
                .loanDate(loan.getLoanDate())
                .expectedReturnDate(loan.getExpectedReturnDate())
                .actualReturnDate(loan.getActualReturnDate())
                .build();
    }
}
