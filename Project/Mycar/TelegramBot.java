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


        String answer = "Аналитика цен для Toyota Camry:\n" +"Год: 2018\n"+ "Объем: 2л\n"
                + "Средняя цена: 13 633 500 т\n" + "Средний пробег: 80437 км\n"+ "Количество продаж: 32\n" + "\n" + "Год: 2018\n"+ "Объем: 2.5л\n" +"Средняя цена: 15 480 000 т\n"
                +"Средний пробег: 89075 км\n"+ "Количество продаж: 615\n" + "\n"
                +"Год: 2018\n" + "Объем: 3.5л\n"+"Средняя цена: 18 325 000 n\n"+"Средний пробег: 94000 км\n"+"Количество продаж: 23\n";
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
