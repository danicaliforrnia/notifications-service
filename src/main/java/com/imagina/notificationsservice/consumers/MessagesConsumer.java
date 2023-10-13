package com.imagina.notificationsservice.consumers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessagesConsumer {

    @RabbitListener(queues = "q.send-emails")
    public void handleEmailsMessages(Object message) {
        log.info("(send-emails) Message: {}", message.toString());
    }

    @RabbitListener(queues = "q.send-sms")
    public void handleSmsMessage(Object message) {
        log.info("(send-sms) Message: {}", message.toString());
    }
}
