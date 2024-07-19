package uz.pdp.appwaterdeliver.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appwaterdeliver.entity.TelegramUser;
import uz.pdp.appwaterdeliver.entity.User;
import uz.pdp.appwaterdeliver.enums.TelegramState;
import uz.pdp.appwaterdeliver.repo.TelegramUserRepository;
import uz.pdp.appwaterdeliver.repo.UserRepository;
import uz.pdp.appwaterdeliver.utils.PhoneRepairUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BotService implements BotserviceI {
    private final TelegramUserRepository telegramUserRepository;
    private final BotUtils botUtils;
    private final TelegramBot telegramBot;
    private final UserRepository userRepository;

    @Override
    public TelegramUser getOrCreatTelegramUser(Long chatId) {
        Optional<TelegramUser> byChatId = telegramUserRepository.findByChatId(chatId);
        if (byChatId.isPresent()) {
            return byChatId.get();
        } else {
            TelegramUser telegramUser = new TelegramUser(chatId);
            telegramUserRepository.save(telegramUser);
            return telegramUser;

        }

    }

    @Override
    public void accepStartSendShareContact(Message message, TelegramUser tgUser) {
        SendMessage sendMessage = new SendMessage(message.chat().id(), BotConstant.PLEAS_SHARE_CONTACT);
        sendMessage.replyMarkup(botUtils.generateContactButton());
        telegramBot.execute(sendMessage);
        tgUser.setTelegramState(TelegramState.SHARE_CONTACT);
        telegramUserRepository.save(tgUser);
    }

    @Override
    public void accepStartSendRegionButton(Contact contact, TelegramUser tgUser) {
        String phoneNumber = PhoneRepairUtil.repairPhone(contact.phoneNumber());
        User user = User.builder()
                .phone(phoneNumber)
                .build();
        userRepository.save(user);
        tgUser.setUser(user);
        tgUser.setTelegramState(TelegramState.SELECT_REGION);

        SendMessage message= new SendMessage(tgUser.getChatId(),BotConstant.SELECT_REGION);

        telegramUserRepository.save(tgUser);
    }
}
