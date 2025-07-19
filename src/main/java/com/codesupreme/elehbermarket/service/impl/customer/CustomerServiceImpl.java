package com.codesupreme.elehbermarket.service.impl.customer;

import com.codesupreme.elehbermarket.dao.customer.CustomerRepository;
import com.codesupreme.elehbermarket.dto.customer.CustomerDto;
import com.codesupreme.elehbermarket.model.customer.Customer;
import com.codesupreme.elehbermarket.service.inter.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .imageUrl(customer.getImageUrl())
                .password(customer.getPassword())
                .address(customer.getAddress())
                .isDisable(customer.getIsDisable())
                .createdAt(customer.getCreatedAt())
                .build();
    }

    private Customer toEntity(CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .phone(dto.getPhone())
                .imageUrl(dto.getImageUrl())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .isDisable(dto.getIsDisable())
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        return toDto(customerRepository.save(toEntity(dto)));
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public CustomerDto login(String phone, String password) {
        Customer customer = customerRepository.findByPhoneAndPassword(phone, password)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı və ya şifrə yanlışdır"));
        return toDto(customer);
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto dto) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFullName(dto.getFullName());
            customer.setPhone(dto.getPhone());
            customer.setImageUrl(dto.getImageUrl());
            customer.setPassword(dto.getPassword());
            customer.setAddress(dto.getAddress());
            customer.setIsDisable(dto.getIsDisable());
            return toDto(customerRepository.save(customer));
        }).orElse(null);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
