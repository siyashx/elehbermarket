package com.codesupreme.elehbermarket.dto.courier;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourierDto {
    private Long id;
    private String fullName;
    private String phone;
    private String imageUrl;
    private String password;
    private Boolean isDisable;
    private Date createdAt;
}
