package com.library.user_service.controller;

import com.library.user_service.model.dto.request.CustomerRequestDto;
import com.library.user_service.model.dto.response.CustomerResponseDto;
import com.library.user_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.create(customerRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerResponseDto>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

}
