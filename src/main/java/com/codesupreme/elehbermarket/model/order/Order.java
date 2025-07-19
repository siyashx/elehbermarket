package com.codesupreme.elehbermarket.model.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String address;

    private String status;

    private Long customerId;
    private Long courierId;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    private List<ProductItem> products;


    private Double price;

    private String description;

    private Boolean isDisable;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
