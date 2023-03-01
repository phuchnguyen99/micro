package com.pnguye38.notification;

import com.pnguye38.client.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Notification for customer {}", notificationRequest.toCustomerId());
        notificationService.sendNotification(notificationRequest);
    }
}
