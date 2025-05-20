package ru.maverick.sportsupportbot.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maverick.sportsupportbot.workout.model.Workout;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserTelegramIdAndType(String telegramId, String type);
    List<Workout> findDistinctByType();
}
