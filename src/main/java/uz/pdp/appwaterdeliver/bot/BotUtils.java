package uz.pdp.appwaterdeliver.bot;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Service;

@Service
public class BotUtils {
    public Keyboard generateContactButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(

                new KeyboardButton(
                        BotConstant.SHARE_CONTACT
                ).requestContact(true)
        ).resizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public Keyboard generateLocationButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(

                new KeyboardButton(
                        BotConstant.SHARE_LOCATION
                ).requestLocation(true)
        ).resizeKeyboard(true);
        return replyKeyboardMarkup;
    }
}
