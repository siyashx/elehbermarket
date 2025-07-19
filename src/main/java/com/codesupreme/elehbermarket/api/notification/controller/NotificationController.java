package com.codesupreme.elehbermarket.api.notification.controller;

import com.codesupreme.elehbermarket.dto.notification.NotificationDto;
import com.codesupreme.elehbermarket.service.inter.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v9/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public ResponseEntity<NotificationDto> create(@RequestBody NotificationDto dto) {
        return ResponseEntity.ok(service.createNotification(dto));
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAll() {
        return ResponseEntity.ok(service.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getNotificationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDto> update(@PathVariable Long id, @RequestBody NotificationDto dto) {
        return ResponseEntity.ok(service.updateNotification(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
