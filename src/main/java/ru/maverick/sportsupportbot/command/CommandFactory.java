package ru.maverick.sportsupportbot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {

    private final Map<String, Command> commands = new HashMap<>();

    @Autowired
    public CommandFactory(List<Command> commandList) {
        for (Command command : commandList) {
            commands.put(command.getCommand(), command);
        }
    }

    public Command getCommand(String commandText) {
        return commands.getOrDefault(commandText, commands.get("/unknown"));
    }
}