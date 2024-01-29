package pl.drybanski.court.reservation;

import pl.drybanski.court.user.User;

import java.time.LocalDateTime;

public class ReservationDTO {
    private LocalDateTime localDateTime;
    private User user;
    public ReservationDTO() {
    }
    public ReservationDTO(LocalDateTime localDateTime, User user) {
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
}
