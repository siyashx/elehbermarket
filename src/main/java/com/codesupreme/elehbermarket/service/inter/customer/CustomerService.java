package com.codesupreme.elehbermarket.service.inter.customer;

import com.codesupreme.elehbermarket.dto.customer.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto dto);
    CustomerDto getCustomerById(Long id);
    CustomerDto login(String phone, String password);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto dto);
    void deleteCustomer(Long id);
}
