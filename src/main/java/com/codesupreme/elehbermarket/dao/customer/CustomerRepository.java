package com.codesupreme.elehbermarket.dao.customer;

import com.codesupreme.elehbermarket.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPhoneAndPassword(String phone, String password);
}
