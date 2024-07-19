package uz.pdp.appwaterdeliver;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AppWaterDeliverApplication {

    @Value("${bot.token}")
    private String botToken;

    public static void main(String[] args) {
        SpringApplication.run(AppWaterDeliverApplication.class, args);
    }


    @Bean
    public TelegramBot telegramBot() {
        return new TelegramBot(botToken);
    }

}
