package com.codesupreme.elehbermarket.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String unit;
    private String imageUrl;
    private String category;
}
