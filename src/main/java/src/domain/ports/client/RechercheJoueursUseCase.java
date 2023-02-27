package src.domain.ports.client;

import src.domain.functional.model.Compte;

import java.util.List;


public interface RechercheJoueursUseCase {
    List<Compte> rechercheListeJoueur();
}
