package pl.drybanski.court.player;

import jakarta.persistence.Entity;

@Entity
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
