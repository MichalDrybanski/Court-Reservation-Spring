package pl.drybanski.court.court;

public class CourtDTO {
    private String name;
    private CourtType courtType;
    private boolean available;

    public CourtDTO(String name, CourtType courtType, boolean available) {
        this.name = name;
        this.courtType = courtType;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
