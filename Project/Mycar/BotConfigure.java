package Project.Mycar;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Data
@EnableScheduling
@PropertySource("application.properties")

public class BotConfigure {
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token;


    public String getBotName() {
        return botName;
    }
    public String getToken() {
        return token;
    }
}
