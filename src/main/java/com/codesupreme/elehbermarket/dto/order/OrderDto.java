package com.codesupreme.elehbermarket.dto.order;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String date;
    private String address;
    private String status;
    private Double price;
    private String description;
    private Boolean isDisable;
    private Date createdAt;
}
