package src.domain.functional.service;

import src.domain.functional.DTOs.CreationCompteCommand;
import src.domain.ports.client.CreationCompteUseCase;
import src.domain.ports.server.ComptePersistenceSpi;
import src.domain.functional.model.Compte;

public class CreationCompteService implements CreationCompteUseCase {
    private final ComptePersistenceSpi repository;

    public CreationCompteService(ComptePersistenceSpi repository) {
        this.repository = repository;
    }


    @Override
    public Compte create(CreationCompteCommand creationCompteCommand) {
        Compte compte = new Compte(creationCompteCommand.getPseudo());
        repository.save(compte);
        return compte;
    }
}
