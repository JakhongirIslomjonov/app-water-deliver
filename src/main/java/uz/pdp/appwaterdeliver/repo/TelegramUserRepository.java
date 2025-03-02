package uz.pdp.appwaterdeliver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwaterdeliver.entity.TelegramUser;

import java.util.Optional;
import java.util.UUID;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, UUID> {
    Optional<TelegramUser> findByChatId(Long chatId);

}