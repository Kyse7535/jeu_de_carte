package application.port.in.DTOs;

import domain.Compte;
import domain.Deck;

public class RechercheHerosCommand {
    private Deck deck;

    public RechercheHerosCommand(Compte joueur) {
        this.deck = joueur.getDeck();
    }
}
