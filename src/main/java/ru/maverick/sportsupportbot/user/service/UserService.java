package ru.maverick.sportsupportbot.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maverick.sportsupportbot.user.model.User;
import ru.maverick.sportsupportbot.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getOrCreateUser(String telegramId) {
        return userRepository.findById(telegramId)
                .orElseGet(() -> {
                    User user = new User();
                    user.setTelegramId(telegramId);
                    user.setState(User.UserState.IDLE);
                    return userRepository.save(user);
                });
    }

    public void setUserState(String telegramId, User.UserState state) {
        User user = getOrCreateUser(telegramId);
        user.setState(state);
        userRepository.save(user);
    }

    public User.UserState getUserState(String telegramId) {
        return getOrCreateUser(telegramId).getState();
    }
}