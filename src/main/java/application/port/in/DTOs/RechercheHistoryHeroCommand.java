package application.port.in.DTOs;

import domain.Heros;

import java.util.UUID;

public class RechercheHistoryHeroCommand {
    private final String id;

    public RechercheHistoryHeroCommand(String id) {
        this.id = id;
    }

    public String getHerosId() {
        return id;
    }
}
