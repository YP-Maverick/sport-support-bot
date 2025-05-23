package ru.maverick.sportsupportbot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    SendMessage execute(Update update);
    String getCommand();
}
