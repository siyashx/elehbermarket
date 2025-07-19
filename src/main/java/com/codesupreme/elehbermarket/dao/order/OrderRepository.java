package com.codesupreme.elehbermarket.dao.order;

import com.codesupreme.elehbermarket.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
