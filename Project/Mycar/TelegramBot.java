package Project.Mycar;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    BotConfigure config;

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }



    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();

            switch (message){
                case "2018":
                    try {
                        startCommand(chatID,update.getMessage().getChat().getFirstName());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    message = "";
                    try {
                        sendMessage(chatID, message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private void startCommand(long chatID, String name) throws TelegramApiException {


        String answer = "";
        sendMessage(chatID, answer);
    }

    private void sendMessage(long chatID, String textFormessage) throws TelegramApiException{
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatID));
        sendMessage.setText(textFormessage);

        try{
            execute(sendMessage);
        }catch (TelegramApiException e){

        }
    }

}
