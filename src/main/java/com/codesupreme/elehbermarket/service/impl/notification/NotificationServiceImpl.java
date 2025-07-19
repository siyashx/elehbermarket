package com.codesupreme.elehbermarket.service.impl.notification;

import com.codesupreme.elehbermarket.dao.notification.NotificationRepository;
import com.codesupreme.elehbermarket.dto.notification.NotificationDto;
import com.codesupreme.elehbermarket.model.notification.Notification;
import com.codesupreme.elehbermarket.service.inter.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    private NotificationDto toDto(Notification n) {
        return NotificationDto.builder()
                .id(n.getId())
                .title(n.getTitle())
                .message(n.getMessage())
                .date(n.getDate())
                .build();
    }

    private Notification toEntity(NotificationDto dto) {
        return Notification.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .message(dto.getMessage())
                .date(dto.getDate())
                .build();
    }

    @Override
    public NotificationDto createNotification(NotificationDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public List<NotificationDto> getAllNotifications() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public NotificationDto updateNotification(Long id, NotificationDto dto) {
        return repository.findById(id).map(n -> {
            n.setTitle(dto.getTitle());
            n.setMessage(dto.getMessage());
            n.setDate(dto.getDate());
            return toDto(repository.save(n));
        }).orElse(null);
    }

    @Override
    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }
}
