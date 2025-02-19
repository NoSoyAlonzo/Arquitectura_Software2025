
import java.util.List;
import java.util.Map;

public class FormatFile {

    public static String formatText(List<Map<String, String>> configs) {
        StringBuilder formattedText = new StringBuilder();
        for (Map<String, String> config : configs) {
            formattedText.append("Servidor: ").append(config.get("Servidor"))
                    .append(" | Cuenta: ").append(config.get("Cuenta"))
                    .append(" | Protocolo: ").append(config.get("Protocolo"))
                    .append("\n");
        }
        return formattedText.toString().trim();
    }

}
