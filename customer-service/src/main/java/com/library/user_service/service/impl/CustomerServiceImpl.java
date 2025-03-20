package com.library.user_service.service.impl;

import com.library.user_service.model.dto.request.CustomerRequestDto;
import com.library.user_service.model.dto.response.CustomerResponseDto;
import com.library.user_service.model.entity.Customer;
import com.library.user_service.repository.CustomerRepository;
import com.library.user_service.service.CustomerService;
import com.library.user_service.utils.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) {
        // Convertir el request a Book
        Customer book = customerMapper.toEntity(customerRequestDto);

        //Crear book
        Customer createdCustomer = customerRepository.save(book);

        // Loggear el book creado
        log.info("Book created: {}", createdCustomer);

        // Convertir el book a BookResponseDTO para retornarlo
        return customerMapper.toDto(createdCustomer);
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customerMapper::toDto) // Convertir cada book a BookResponseDTO
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return customer.map(customerMapper::toDto).orElse(null);
    }
}
