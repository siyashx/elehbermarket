package com.codesupreme.elehbermarket.dto.order;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Long customerId;
    private Long courierId;
    private List<ProductItemDto> products;
    private String date;
    private String address;
    private String status;
    private Double price;
    private String description;
    private Boolean isDisable;
    private Date createdAt;
}
