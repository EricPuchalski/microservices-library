package com.library.loan_service.service.impl;

import com.library.loan_service.model.dto.request.LoanRequestDto;
import com.library.loan_service.model.dto.response.BookResponseDto;
import com.library.loan_service.model.dto.response.CustomerResponseDto;
import com.library.loan_service.model.dto.response.LoanResponseDto;
import com.library.loan_service.model.entity.Loan;
import com.library.loan_service.repository.LoanRepository;
import com.library.loan_service.service.LoanService;
import com.library.loan_service.utils.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final WebClient.Builder webClientBuilder;

    @Override
    public LoanResponseDto create(LoanRequestDto loanRequestDto) {
        // 1. Obtener la información del cliente
        log.info("Obteniendo información del cliente con id: {} y book id: {}", loanRequestDto.getCustomerId(), loanRequestDto.getBookId());
        CustomerResponseDto customerResponseDto = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/api/v1/customers/{id}", loanRequestDto.getCustomerId())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        Mono.error(new RuntimeException("Customer not found")))
                .bodyToMono(CustomerResponseDto.class)
                .block(); // Bloquea hasta obtener la respuesta

        // 2. Verificar que el libro existe y está disponible
        BookResponseDto bookResponseDto = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/api/v1/books/{id}", loanRequestDto.getBookId())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new RuntimeException("Book not found")))
                .bodyToMono(BookResponseDto.class)
                .block(); // Bloquea hasta obtener la respuesta

        // 3. Crear el préstamo
        Loan loan = loanMapper.toEntity(loanRequestDto);

        // Establecer loanDate a la fecha y hora actuales
        loan.setLoanDate(LocalDateTime.now());

        // Establecer expectedReturn a 30 días después de loanDate
        loan.setExpectedReturnDate(loan.getLoanDate().plusDays(30));

        Loan createdLoan = loanRepository.save(loan);

        // 4. Retornar el préstamo creado
        return loanMapper.toDto(createdLoan);
    }


    @Override
    public List<LoanResponseDto> findAll() {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream()
                .map(loanMapper::toDto)
                .collect(Collectors.toList());
    }
}
