package com.imagina.notificationsservice.consumers;

import com.imagina.notificationsservice.models.Data;
import com.imagina.notificationsservice.services.EmailsService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class MessagesConsumer {

    private final EmailsService emailsService;

    public MessagesConsumer(EmailsService emailsService) {
        this.emailsService = emailsService;
    }

    @RabbitListener(queues = "q.send-email")
    public void handleEmailsMessages(Data message) throws MessagingException {
        log.info("(send-email) Message: {}", message.toString());
        emailsService.sendMail(message);
    }

    @RabbitListener(queues = "q.send-sms")
    public void handleSmsMessage(Object message) {
        log.info("(send-sms) Message: {}", message.toString());
    }
}
