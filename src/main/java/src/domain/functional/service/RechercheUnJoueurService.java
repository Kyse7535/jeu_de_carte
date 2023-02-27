package src.domain.functional.service;

import src.domain.functional.DTOs.RechercheUnJoueurCommand;
import src.domain.ports.client.RechercheUnJoueurUseCase;
import src.domain.ports.server.ComptePersistenceSpi;
import src.domain.functional.model.Compte;

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
