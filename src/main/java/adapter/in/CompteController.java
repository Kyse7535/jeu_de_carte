package adapter.in;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import domain.Deck;

public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;

    public CompteController(CreationCompteUseCase creationCompteUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
    }

    public void create(String pseudo, Deck deck) {
        creationCompteUseCase.create(new CreationCompteCommand(pseudo,deck));
    }
}
