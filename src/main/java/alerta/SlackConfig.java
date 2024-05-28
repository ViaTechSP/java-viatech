package alerta;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackConfig {
    private String token = "xoxb-7163001649796-7162312869991-47uQKXQq7zMrGnR17ueKdzdR";
    private String channel;
    private String message;

    public String getToken() {
        return token;
    }

    public String getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage(String message, String channel) throws Exception {
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
