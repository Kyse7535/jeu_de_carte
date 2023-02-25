package application.services;

import application.port.in.UseCases.RechercheJoueursUseCase;
import application.port.out.ComptePersistenceSpi;
import domain.Compte;

import java.util.ArrayList;
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
