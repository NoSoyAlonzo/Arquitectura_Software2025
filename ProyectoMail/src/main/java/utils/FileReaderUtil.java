package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderUtil {

    public static List<Map<String, String>> readFile(String filePath) {
        List<Map<String, String>> configurations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue; // Ignorar líneas vacías y comentarios
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    Map<String, String> config = new HashMap<>();
                    config.put("Servidor", parts[0].trim());
                    config.put("Cuenta", parts[1].trim());
                    config.put("Protocolo", parts[2].trim());
                    configurations.add(config);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return configurations;
    }

}
