package application.services;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import application.port.out.CompteRepository;
import domain.Compte;

public class CreationCompteService implements CreationCompteUseCase {
    private final CompteRepository repository;

    public CreationCompteService(CompteRepository repository) {
        this.repository = repository;
    }


    @Override
    public Compte create(CreationCompteCommand creationCompteCommand) {
        Compte compte = new Compte(creationCompteCommand.getPseudo());
        if(repository.load_compte(compte.getPseudo())==null) {
            repository.save(compte);
            return compte;
        }
        else throw new RuntimeException("Un compte avec le meme pseudo existe deja");
    }
}
