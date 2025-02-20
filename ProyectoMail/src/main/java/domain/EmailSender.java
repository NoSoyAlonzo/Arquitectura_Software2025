package domain;

public interface EmailSender {
    void sendEmail(String from, String to, String subject, String body, String username, String password)
            throws Exception;
}