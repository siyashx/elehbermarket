package com.codesupreme.elehbermarket.service.impl.order;

import com.codesupreme.elehbermarket.dao.order.OrderRepository;
import com.codesupreme.elehbermarket.dao.product.ProductRepository;
import com.codesupreme.elehbermarket.dto.order.OrderDto;
import com.codesupreme.elehbermarket.dto.order.ProductItemDto;
import com.codesupreme.elehbermarket.dto.product.ProductDto;
import com.codesupreme.elehbermarket.model.order.Order;
import com.codesupreme.elehbermarket.model.order.ProductItem;
import com.codesupreme.elehbermarket.model.product.Product;
import com.codesupreme.elehbermarket.service.inter.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private OrderDto toDto(Order order) {
        List<ProductItemDto> productItemDtos = order.getProducts().stream().map(item -> {
            ProductDto productDto = getProductDtoById(item.getProductId());
            return ProductItemDto.builder()
                    .productId(item.getProductId())
                    .quantity(item.getQuantity())
                    .product(productDto)
                    .build();
        }).collect(Collectors.toList());

        return OrderDto.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .courierId(order.getCourierId())
                .products(productItemDtos)
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
        List<ProductItem> items = dto.getProducts().stream().map(itemDto ->
                ProductItem.builder()
                        .productId(itemDto.getProductId()) // buradan gəlir artıq
                        .quantity(itemDto.getQuantity())
                        .build()
        ).collect(Collectors.toList());

        return Order.builder()
                .id(dto.getId())
                .customerId(dto.getCustomerId())
                .courierId(dto.getCourierId())
                .products(items)
                .date(dto.getDate())
                .address(dto.getAddress())
                .status(dto.getStatus())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .isDisable(dto.getIsDisable())
                .build();
    }


    private ProductDto getProductDtoById(Long id) {
        return productRepository.findById(id)
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .unit(product.getUnit())
                        .imageUrl(product.getImageUrl())
                        .category(product.getCategory())
                        .build())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
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
