package uz.pdp.appwaterdeliver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appwaterdeliver.entity.abs.AbsEntity;
import uz.pdp.appwaterdeliver.enums.TelegramState;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelegramUser extends AbsEntity {

    private Long chatId;


    @Enumerated(EnumType.STRING)
    private TelegramState telegramState = TelegramState.START;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    public TelegramUser( Long chatId) {
        this.chatId = chatId;
    }
}
