package application.services;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import application.port.out.Repository;
import domain.Compte;

public class CreationCompteService implements CreationCompteUseCase {
    private final Repository repository;

    public CreationCompteService(Repository repository) {
        this.repository = repository;
    }


    @Override
    public void create(CreationCompteCommand creationCompteCommand) {
        Compte compte = new Compte(creationCompteCommand.getPseudo(),creationCompteCommand.getDeck());
        repository.save(compte);
    }
}
