package com.codesupreme.elehbermarket.dao.product;

import com.codesupreme.elehbermarket.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
