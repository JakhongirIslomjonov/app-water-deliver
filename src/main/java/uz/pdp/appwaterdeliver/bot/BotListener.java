package uz.pdp.appwaterdeliver.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BotListener implements CommandLineRunner {
    private final BotController botController;
    private final TelegramBot telegramBot;

    @Override
    public void run(String... args) throws Exception {
        telegramBot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                botController.handle(update);
            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
