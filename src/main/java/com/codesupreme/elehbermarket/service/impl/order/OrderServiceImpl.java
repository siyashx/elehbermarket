package com.codesupreme.elehbermarket.service.impl.order;

import com.codesupreme.elehbermarket.dao.order.OrderRepository;
import com.codesupreme.elehbermarket.dto.order.OrderDto;
import com.codesupreme.elehbermarket.model.order.Order;
import com.codesupreme.elehbermarket.service.inter.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .address(order.getAddress())
                .status(order.getStatus())
                .price(order.getPrice())
                .description(order.getDescription())
                .isDisable(order.getIsDisable())
                .createdAt(order.getCreatedAt())
                .build();
    }

    private Order toEntity(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .address(dto.getAddress())
                .status(dto.getStatus())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .isDisable(dto.getIsDisable())
                .build();
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        return toDto(orderRepository.save(toEntity(dto)));
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto dto) {
        return orderRepository.findById(id).map(order -> {
            order.setDate(dto.getDate());
            order.setAddress(dto.getAddress());
            order.setStatus(dto.getStatus());
            order.setPrice(dto.getPrice());
            order.setDescription(dto.getDescription());
            order.setIsDisable(dto.getIsDisable());
            return toDto(orderRepository.save(order));
        }).orElse(null);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
