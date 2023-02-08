package application.services;

import application.port.in.UseCases.RechercheJoueursUseCase;
import application.port.out.CompteRepository;
import domain.Compte;

import java.util.ArrayList;

public class RechercheJoueursService implements  RechercheJoueursUseCase{
    private final CompteRepository repository;

    public RechercheJoueursService(CompteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Compte> rechercheListeJoueur() {
        return repository.findAllPlayers();
    }
}
