package uz.pdp.appwaterdeliver.bot;


import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uz.pdp.appwaterdeliver.entity.TelegramUser;

@Service
@RequiredArgsConstructor
public class BotController {
    private final BotserviceI botserviceI;

    @Async
    public void handle(Update update) {
        if (update.message() != null) {
            Message message = update.message();
            TelegramUser tgUser = botserviceI.getOrCreatTelegramUser(message.chat().id());
            if (message.text() != null) {
                String text = message.text();
                if (text.equals("/start")) {
                    botserviceI.accepStartSendShareContact(message, tgUser);
                }
            } else if (message.contact() != null) {
                Contact contact = message.contact();

                botserviceI.accepStartSendRegionButton(contact,tgUser);

            } else if (message.location() != null) {


            }
        } else if (update.callbackQuery() != null) {

        }
    }
}

