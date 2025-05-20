package ru.maverick.sportsupportbot.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import ru.maverick.sportsupportbot.supplement.model.Supplement;
import ru.maverick.sportsupportbot.workout.model.Workout;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @Id
    private String telegramId;

    private String language;
    private boolean showBilingualNames;
    private boolean showSupplementInfo;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Workout> workouts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Supplement> supplements;

    private int currentWorkoutIndex;


    public enum UserState {
        IDLE,
        ADDING_SUPPLEMENT,
        ADDING_WORKOUT,
        IN_WORKOUT
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getTelegramId() != null && Objects.equals(getTelegramId(), user.getTelegramId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}