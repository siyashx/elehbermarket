package com.codesupreme.elehbermarket.service.inter.notification;

import com.codesupreme.elehbermarket.dto.notification.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto dto);
    NotificationDto getNotificationById(Long id);
    List<NotificationDto> getAllNotifications();
    NotificationDto updateNotification(Long id, NotificationDto dto);
    void deleteNotification(Long id);
}
