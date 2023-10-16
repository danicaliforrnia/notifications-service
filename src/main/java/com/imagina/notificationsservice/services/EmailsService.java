package com.imagina.notificationsservice.services;

import com.imagina.notificationsservice.models.Data;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Arrays;
import java.util.Map;

@Service
public class EmailsService {

    private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;

    public EmailsService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    public boolean sendMail(Data data) throws MessagingException {
        Context context = new Context();
        context.setVariables(data.getTemplateData());

        String process = templateEngine.process(data.getEmailData().getType(), context);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setSubject(data.getEmailData().getSubject());
        mimeMessageHelper.setText(process, true);
        mimeMessageHelper.setTo(data.getEmailData().getTo());

        javaMailSender.send(mimeMessage);

        return true;
    }
}
