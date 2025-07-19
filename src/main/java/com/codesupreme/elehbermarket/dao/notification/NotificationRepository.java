package com.codesupreme.elehbermarket.dao.notification;

import com.codesupreme.elehbermarket.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
