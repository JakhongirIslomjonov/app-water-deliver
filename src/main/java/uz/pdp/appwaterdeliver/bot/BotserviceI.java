package uz.pdp.appwaterdeliver.bot;

import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import uz.pdp.appwaterdeliver.entity.TelegramUser;

public interface BotserviceI {
    TelegramUser getOrCreatTelegramUser(Long id);

    void accepStartSendShareContact(Message message, TelegramUser tgUser);

    void accepStartSendRegionButton(Contact contact, TelegramUser tgUser);
}
