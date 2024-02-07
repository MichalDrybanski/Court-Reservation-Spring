package pl.drybanski.court.group;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ManyToAny;
import pl.drybanski.court.player.Player;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    private String groupName;
    @Id
    private long id;
    @ManyToOne
    private Player player;

    public Group(String groupName, Player player) {
        this.groupName = groupName;
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
