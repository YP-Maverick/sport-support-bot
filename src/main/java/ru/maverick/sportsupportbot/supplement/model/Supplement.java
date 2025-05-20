package ru.maverick.sportsupportbot.supplement.model;

import lombok.Data;
import jakarta.persistence.*;
import ru.maverick.sportsupportbot.user.model.User;

@Entity
@Data
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dosage;
    private String time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}