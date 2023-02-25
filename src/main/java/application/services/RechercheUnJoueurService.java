package application.services;

import application.port.in.DTOs.RechercheUnJoueurCommand;
import application.port.in.UseCases.RechercheUnJoueurUseCase;
import application.port.out.ComptePersistenceSpi;
import domain.Compte;

public class RechercheUnJoueurService implements RechercheUnJoueurUseCase {
    private final ComptePersistenceSpi repository;

    public RechercheUnJoueurService(ComptePersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public Compte rechercheUnJoueur(RechercheUnJoueurCommand rechercheUnJoueurCommand) {
        Compte compte = repository.load_compte(rechercheUnJoueurCommand.getPseudo());
        if (compte == null) {
            throw new RuntimeException("le compte n'existe pas");
        }
        return compte;
    }
}
