import service.GenericEmailSender;

public class EmailServiceTest {
    public static void main(String[] args) {
        // Datos del correo a enviar
        String fromEmail = "angelrs-2000@hotmail.com"; // Tu dirección de correo
        String toEmail = "angel.reyes215999@potros.itson.edu.mx"; // Dirección de correo del destinatario
        String subject = "Prueba de correo";
        String body = "Este es un correo de prueba enviado desde el programa.";

        // Tu nombre de usuario y contraseña para autenticación
        String username = "xx@xx.com";
        String password = "1234";

        // Seleccionar la configuración (por ejemplo: "HotmailConfig" o "GmailConfig" o
        // la que agregaste)
        String configName = "HotmailConfig";

        try {
            // Crear una instancia de GenericEmailSender
            GenericEmailSender emailSender = new GenericEmailSender();

            // Enviar el correo
            emailSender.sendEmail(fromEmail, toEmail, subject, body, username, password, configName);
        } catch (Exception e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
