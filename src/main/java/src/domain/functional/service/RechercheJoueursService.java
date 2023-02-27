package src.domain.functional.service;

import src.domain.ports.client.RechercheJoueursUseCase;
import src.domain.ports.server.ComptePersistenceSpi;
import src.domain.functional.model.Compte;

import java.util.List;

public class RechercheJoueursService implements  RechercheJoueursUseCase{
    private final ComptePersistenceSpi repository;

    public RechercheJoueursService(ComptePersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public List<Compte> rechercheListeJoueur() {
        return repository.findAllPlayers();
    }
}
