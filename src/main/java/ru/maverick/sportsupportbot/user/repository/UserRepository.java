package ru.maverick.sportsupportbot.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maverick.sportsupportbot.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
