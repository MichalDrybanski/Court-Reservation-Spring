package pl.drybanski.court.group;

import pl.drybanski.court.player.Player;

public class GroupDTO {
    private String groupName;
    private Player player;

    public GroupDTO() {}
    public GroupDTO(String groupName, Player player) {
        this.groupName = groupName;
        this.player = player;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
