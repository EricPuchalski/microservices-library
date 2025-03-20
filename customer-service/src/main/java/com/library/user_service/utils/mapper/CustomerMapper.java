package com.library.user_service.utils.mapper;

import com.library.user_service.model.dto.request.CustomerRequestDto;
import com.library.user_service.model.dto.response.CustomerResponseDto;
import com.library.user_service.model.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequestDto customerRequestDto) {
        if (customerRequestDto == null){
            return null;
        }
        return Customer.builder()
                .name(customerRequestDto.getName())
                .lastname(customerRequestDto.getLastname())
                .email(customerRequestDto.getEmail())
                .phoneNumber(customerRequestDto.getPhoneNumber())
                .build();

    }

    public CustomerResponseDto toDto(Customer customer) {
        if (customer == null){
            return null;
        }
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

}
