package application.port.in.DTOs;

import domain.Heros;

public class RechercheHistoryHeroCommand {
    private final Heros heros;

    public RechercheHistoryHeroCommand(Heros heros) {
        this.heros = heros;
    }

    public Heros getHeros() {
        return heros;
    }
}
