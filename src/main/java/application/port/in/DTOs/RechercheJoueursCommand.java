package application.port.in.DTOs;

import application.port.out.Repository;
import domain.Compte;

public class RechercheJoueursCommand {
    private final Repository<Compte> repository;

    public RechercheJoueursCommand(Repository<Compte> repository) {
        this.repository = repository;
    }
}
