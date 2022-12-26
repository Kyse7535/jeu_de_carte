package application.services;

import application.port.in.DTOs.RechercheJoueursCommand;
import application.port.in.UseCases.RechercheJoueursUseCase;
import application.port.out.CompteRepository;
import domain.Compte;

import java.util.ArrayList;

public class RechercheJoueursService implements RechercheJoueursUseCase {
    private final CompteRepository repository;

    public RechercheJoueursService(CompteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Compte> recherche_liste_joueur(RechercheJoueursCommand rechercheJoueursCommandd) {
        return repository.findAllPlayers();
    }
}
