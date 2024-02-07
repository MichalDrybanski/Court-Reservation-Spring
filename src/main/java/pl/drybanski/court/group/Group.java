package pl.drybanski.court.group;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.drybanski.court.player.Player;

@Entity
@Table(name = "groups")
public class Group {
    private String name;
    @Id
    private long id;
    @ManyToOne
    private Player player;

    public Group() {
    }

    public Group(String name, Player player) {
        this.name = name;
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
