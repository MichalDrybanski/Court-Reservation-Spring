package pl.drybanski.court.court;

import jakarta.persistence.*;

@Entity
@Table(name = "courts")
public class Court {
    private String name;
    private boolean available;
    @Enumerated(EnumType.STRING)
    private CourtType courtType;
    @Id
    @GeneratedValue
    private Long id;

    public Court(String name, boolean available, CourtType courtType) {
        this.name = name;
        this.available = available;
        this.courtType = courtType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }
}
