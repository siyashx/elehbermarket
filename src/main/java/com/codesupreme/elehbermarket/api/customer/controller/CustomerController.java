package com.codesupreme.elehbermarket.api.customer.controller;

import com.codesupreme.elehbermarket.dto.customer.CustomerDto;
import com.codesupreme.elehbermarket.service.inter.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v9/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto dto) {
        return ResponseEntity.ok(customerService.createCustomer(dto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> login(@RequestParam String phone, @RequestParam String password) {
        return ResponseEntity.ok(customerService.login(phone, password));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto dto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
