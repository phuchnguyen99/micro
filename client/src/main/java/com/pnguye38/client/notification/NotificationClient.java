package com.pnguye38.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "fraud",
        url = "${clients.notification.url}"
)
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
