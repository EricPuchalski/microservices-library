package com.library.loan_service.controller;

import com.library.loan_service.model.dto.request.LoanRequestDto;
import com.library.loan_service.model.dto.response.LoanResponseDto;
import com.library.loan_service.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loans")
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LoanResponseDto> create(@RequestBody LoanRequestDto loanRequestDto) {
        return ResponseEntity.ok(loanService.create(loanRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LoanResponseDto>> findAll() {
        return ResponseEntity.ok(loanService.findAll());
    }
}
