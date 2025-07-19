package com.codesupreme.elehbermarket.dto.customer;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    private String fullName;
    private String phone;
    private String imageUrl;
    private String password;
    private String address;
    private Boolean isDisable;
    private Date createdAt;
}
