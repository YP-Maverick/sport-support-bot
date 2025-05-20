package ru.maverick.sportsupportbot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartCommand implements Command {

    @Override
    public SendMessage execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText("Добро пожаловать! Выберите опцию:");
        message.setReplyMarkup(getMainMenuKeyboard());
        return message;
    }

    @Override
    public String getCommand() {
        return "/start";
    }

    private ReplyKeyboardMarkup getMainMenuKeyboard() {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Настройки");
        row1.add("Добавить добавку");
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Добавить тренировку");
        row2.add("Начать тренировку");
        rows.add(row1);
        rows.add(row2);
        keyboard.setKeyboard(rows);
        return keyboard;
    }
}
