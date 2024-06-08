package alerta;
import model.RegistroModel;
import model.SlackModel;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackConfig {
    RegistroModel registroModel = new RegistroModel();
    private String channel;
    private String message;



    public void sendMessage(String message, String channel) throws Exception {
            String token = registroModel.buscarTokenBot();
            String url = "https://slack.com/api/chat.postMessage";

            String jsonPayload = String.format(
                    "{\"channel\":\"%s\",\"text\":\"%s\"}",
                    channel,
                    message
            );

            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Mensagem enviada com sucesso.");
            } else {
                System.out.println("Erro ao enviar mensagem. Código de resposta: " + responseCode);
            }
        }


}
