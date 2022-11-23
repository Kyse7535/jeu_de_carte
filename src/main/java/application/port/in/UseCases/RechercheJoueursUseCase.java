package application.port.in.UseCases;

import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.DTOs.RechercheJoueursCommand;
import domain.Compte;
import domain.Deck;

import java.util.Map;

public interface RechercheJoueursUseCase {
    Map<Compte, Deck> recherche_liste_joueur(RechercheJoueursCommand rechercheJoueursCommand);
}
