package application.services;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import application.port.out.CompteRepository;
import domain.Compte;

public class CreationCompteUseCaseService implements CreationCompteUseCase {
    private final CompteRepository compteRepository;


    public CreationCompteUseCaseService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }


    @Override
    public void creationCompte(CreationCompteCommand creationCompteCommand) {
        Compte compte = new Compte(creationCompteCommand.pseudo,creationCompteCommand.deck);
        compteRepository.save(compte);
    }
}
