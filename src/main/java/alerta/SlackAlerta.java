package alerta;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.Conversation;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SlackAlerta {
        /**
         * Find conversation ID using the conversations.list method
         */
        static void findConversation(String name) {
            // you can get this instance via ctx.client() in a Bolt app
            var client = Slack.getInstance().methods();
            var logger = LoggerFactory.getLogger("my-awesome-slack-app");
            try {
                // Call the conversations.list method using the built-in WebClient
                var result = client.conversationsList(r -> r
                        // The token you used to initialize your app
                        .token(System.getenv("xoxb-7163001649796-7160463394771-xVPkyHk3zqovtMC3YTLZyYof"))
                );
                for (Conversation channel : result.getChannels()) {
                    if (channel.getName().equals(name)) {
                        var conversationId = channel.getId();
                        // Print result
                        logger.info("Found conversation ID: {}", conversationId);
                        // Break from for loop
                        break;
                    }
                }
            } catch (IOException | SlackApiException e) {
                logger.error("error: {}", e.getMessage(), e);
            }
        }

        public static void main(String[] args) throws Exception {
            // Find conversation with a specified channel `name`
            findConversation("  C074QFG0VOS");
        }


}
