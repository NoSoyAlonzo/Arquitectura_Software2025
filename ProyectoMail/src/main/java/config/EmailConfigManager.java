package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EmailConfigManager {
    private Properties properties;

    public EmailConfigManager(String configFilePath, String configName) {
        properties = new Properties();

        try (FileReader reader = new FileReader(configFilePath)) {
            properties.load(reader);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
        }

        // Cargar la configuración seleccionada (por ejemplo, smtpConfig1)
        loadConfiguration(configName);
    }

    private void loadConfiguration(String configName) {
        // Aquí puedes obtener los valores específicos para la configuración
        String smtpServer = properties.getProperty(configName + ".smtpServer");
        String port = properties.getProperty(configName + ".port");
        String protocol = properties.getProperty(configName + ".protocol");

        System.out.println("Configuración seleccionada:");
        System.out.println("Servidor SMTP: " + smtpServer);
        System.out.println("Puerto: " + port);
        System.out.println("Protocolo: " + protocol);
    }

    // Métodos adicionales para acceder a las propiedades
    public String getSmtpServer() {
        return properties.getProperty("smtpServer");
    }

    public String getPort() {
        return properties.getProperty("port");
    }

    public String getProtocol() {
        return properties.getProperty("protocol");
    }
}
