package pl.drybanski.court.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.drybanski.court.player.Player;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String email;
    private String password;
    @OneToOne
    private Player player;

    public User() {
    }
    public User(String name, String password) {
        this.email = name;
        this.password = password;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
