package com.codesupreme.elehbermarket.dto.order;
import com.codesupreme.elehbermarket.dto.product.ProductDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemDto {
    private Long productId;        // frontend bu sahəni göndərəcək
    private Integer quantity;

    private ProductDto product;    // toDto üçün backend dolduracaq
}

