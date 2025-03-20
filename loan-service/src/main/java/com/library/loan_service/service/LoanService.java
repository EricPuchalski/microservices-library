package com.library.loan_service.service;

import com.library.loan_service.model.dto.request.LoanRequestDto;
import com.library.loan_service.model.dto.response.LoanResponseDto;

import java.util.List;

public interface LoanService {
    LoanResponseDto create(LoanRequestDto loanRequestDto);

    List<LoanResponseDto> findAll();
}
