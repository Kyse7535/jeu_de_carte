package application.services;

import application.port.in.DTOs.RechercheUnJoueurCommand;
import application.port.in.UseCases.RechercheUnJoueurUseCase;
import application.port.out.CompteRepository;
import domain.Compte;

public class RechercheUnJoueurService implements RechercheUnJoueurUseCase {
    private final CompteRepository repository;

    public RechercheUnJoueurService(CompteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Compte recherche_un_joueur(RechercheUnJoueurCommand rechercheUnJoueurCommand) {
        return repository.load_compte(rechercheUnJoueurCommand.getPseudo());
    }
}
