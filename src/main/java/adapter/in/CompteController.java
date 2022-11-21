package adapter.in;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import domain.Compte;
import domain.Deck;

public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;

    public CompteController(CreationCompteUseCase creationCompteUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
    }

    public Compte create(String pseudo, Deck deck) {
        return creationCompteUseCase.creationCompte(new CreationCompteCommand(pseudo,deck));
    }
}
