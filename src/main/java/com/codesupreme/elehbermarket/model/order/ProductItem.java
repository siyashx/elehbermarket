package com.codesupreme.elehbermarket.model.order;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    private Long productId;
    private Integer quantity;
}

