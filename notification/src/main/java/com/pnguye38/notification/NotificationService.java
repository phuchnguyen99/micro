package com.pnguye38.notification;

import com.pnguye38.client.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        final Notification notification =
                Notification
                        .builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .message(notificationRequest.message())
                        .sender("phuchnguyen99@gmail.com")
                        .sentAt(LocalDateTime.now())
                        .build();

        notificationRepository.save(notification);
    }
}
