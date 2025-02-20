package service;

import domain.EmailSender;

public class EmailService {

    private final EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(String from, String to, String subject, String body, String username, String password)
            throws Exception {
        emailSender.sendEmail(from, to, subject, body, username, password);
    }
}
