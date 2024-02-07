package pl.drybanski.court.group;

public class GroupDTO {
    private String name;
    private long playerId;

    public GroupDTO() {}

    public GroupDTO(String name, long playerId) {
        this.name = name;
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
