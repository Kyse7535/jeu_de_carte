package application.port.in.DTOs;

public class RechercheHistoryHeroCommand {
    private final String id;

    public RechercheHistoryHeroCommand(String id) {
        this.id = id;
    }

    public String getHerosId() {
        return id;
    }
}
