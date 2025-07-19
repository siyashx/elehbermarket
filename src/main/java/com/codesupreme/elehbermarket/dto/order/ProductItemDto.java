package com.codesupreme.elehbermarket.dto.order;
import com.codesupreme.elehbermarket.dto.product.ProductDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemDto {
    private ProductDto product;
    private Integer quantity;
}

