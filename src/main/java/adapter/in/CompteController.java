package adapter.in;

import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.DTOs.RechercheJoueursCommand;
import application.port.in.UseCases.CreationCompteUseCase;
import application.port.in.UseCases.RechercheJoueursUseCase;
import application.port.out.Repository;
import domain.Compte;
import domain.Deck;

import java.util.Map;

public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;
    private final RechercheJoueursUseCase rechercheJoueursUseCase;

    public CompteController(CreationCompteUseCase creationCompteUseCase, RechercheJoueursUseCase rechercheJoueursUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
        this.rechercheJoueursUseCase = rechercheJoueursUseCase;
    }

    public void create(String pseudo, Deck deck) {
        creationCompteUseCase.create(new CreationCompteCommand(pseudo,deck));
    }

    public Map<Compte, Deck> recherche_liste_joueur(Repository<Compte> repository) {
        return rechercheJoueursUseCase.recherche_liste_joueur(new RechercheJoueursCommand(repository));
    }
}
