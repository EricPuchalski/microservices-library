package com.library.user_service.service;

import com.library.user_service.model.dto.request.CustomerRequestDto;
import com.library.user_service.model.dto.response.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerResponseDto create(CustomerRequestDto customerRequestDto);

    List<CustomerResponseDto> findAll();

    CustomerResponseDto findById(Long id);
}
