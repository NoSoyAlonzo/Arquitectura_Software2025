package service;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GenericEmailSender {

    // Método para enviar un correo electrónico con la configuración seleccionada
    public void sendEmail(String from,
            String to,
            String subject,
            String body,
            String username,
            String password,
            String configName) throws Exception {

        // Cargar todas las configuraciones del archivo de propiedades
        Properties config = loadEmailConfig(); // Método para cargar el archivo .txt

        // Seleccionar la configuración específica usando el nombre de la configuración
        String host = config.getProperty(configName + ".host"); // Obtiene el host
        String port = config.getProperty(configName + ".port"); // Obtiene el puerto
        String protocol = config.getProperty(configName + ".protocol"); // Obtiene el protocolo (SMTP, IMAP, etc.)

        // Verifica si las configuraciones se han cargado correctamente
        if (host == null || port == null || protocol == null) {
            throw new Exception("Configuración no encontrada para: " + configName);
        }

        // Configurar las propiedades del correo
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // Establece el host de SMTP
        props.put("mail.smtp.port", port); // Establece el puerto de SMTP
        props.put("mail.smtp.auth", "true"); // Habilita la autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilita TLS

        // Crea una sesión de correo con autenticación
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password); // Autenticación con username y password
            }
        });

        // Crea el mensaje de correo
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from)); // Establece la dirección de envío
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // Establece el destinatario
        message.setSubject(subject); // Establece el asunto
        message.setText(body); // Establece el cuerpo del mensaje

        // Envía el correo
        Transport.send(message);
        System.out.println("Correo enviado exitosamente a " + to);
    }

    // Método para cargar la configuración desde el archivo de propiedades
    private Properties loadEmailConfig() throws Exception {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(
                "config/email_config.txt")) {
            properties.load(fileInputStream); // Carga las propiedades del archivo .txt
        } catch (Exception e) {
            throw new Exception("Error al cargar la configuración del archivo", e);
        }

        return properties;
    }
}
