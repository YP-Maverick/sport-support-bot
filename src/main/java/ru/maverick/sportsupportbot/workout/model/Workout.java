package ru.maverick.sportsupportbot.workout.model;

import lombok.Data;
import jakarta.persistence.*;
import ru.maverick.sportsupportbot.user.model.User;

@Entity
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int sets;
    private String weight;
    private int reps;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}