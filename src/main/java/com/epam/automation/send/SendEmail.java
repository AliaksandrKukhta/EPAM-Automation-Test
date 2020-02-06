package com.epam.automation.send;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {
    public void sendAPIMessage() {
        String to = "com.epam.automation.mail-test2@tut.by";
        String from = "com.epam.automation.mail-test1@tut.by";
        String host = "smtp.yandex.ru";
        int port = 465;
        Properties props = new Properties();
        props.put("com.epam.automation.mail.smtp.host", host);
        props.put("com.epam.automation.mail.smtp.ssl.enable", "true");
        props.put("com.epam.automation.mail.smtp.port", port);
        props.put("com.epam.automation.mail.smtp.auth", "true");
        props.put("com.epam.automation.mail.debug", "true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            // Указываем логин пароль, от почты, с которой будем отправлять сообщение.
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("com.epam.automation.mail-test1@tut.by", "MailTest");
            }
        });
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");
            msg.setSentDate(new Date());
            msg.setText("Test Automation");
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
