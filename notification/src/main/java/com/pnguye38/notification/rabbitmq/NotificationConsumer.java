package com.pnguye38.notification.rabbitmq;

import com.pnguye38.client.notification.NotificationRequest;
import com.pnguye38.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "notification.queue")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consume {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
