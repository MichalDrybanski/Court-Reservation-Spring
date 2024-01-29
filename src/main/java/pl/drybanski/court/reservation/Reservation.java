package pl.drybanski.court.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pl.drybanski.court.user.User;

import java.time.LocalDateTime;
@Entity
@Table(name = "reservation")
public class Reservation {
    private LocalDateTime localDateTime;
    private User user;
    @Id
    @GeneratedValue
    private Long id;

    public Reservation() {
    }

    public Reservation(LocalDateTime localDateTime, User user) {
        this.localDateTime = localDateTime;
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
