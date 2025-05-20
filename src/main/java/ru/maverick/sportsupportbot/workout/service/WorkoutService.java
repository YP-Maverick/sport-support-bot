package ru.maverick.sportsupportbot.workout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maverick.sportsupportbot.user.service.UserService;
import ru.maverick.sportsupportbot.workout.mapper.WorkoutMapper;
import ru.maverick.sportsupportbot.workout.model.Workout;
import ru.maverick.sportsupportbot.workout.repository.WorkoutRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;
    private final WorkoutMapper workoutMapper;

    public void addWorkout(String telegramId, String input) {
        String[] parts = input.split(" ");
        Workout workout = new Workout();
        workout.setName(parts[0]);
        workout.setType(parts[0]); // Тип тренировки совпадает с именем для простоты
        workout.setSets(Integer.parseInt(parts[1]));
        workout.setWeight(parts[2]);
        workout.setReps(Integer.parseInt(parts[3]));
        workout.setUser(userService.getOrCreateUser(telegramId));
        workoutRepository.save(workout);
    }
}