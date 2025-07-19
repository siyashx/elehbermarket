package com.codesupreme.elehbermarket.dto.notification;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private Long id;
    private Long customerId;
    private Long courierId;
    private String title;
    private String message;
    private String date;
}
