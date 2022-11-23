package application.port.in.DTOs;

import domain.Deck;

public class CreationCompteCommand {
    private final String pseudo;
    private Deck deck;
    private int nbr_jetons;

    public CreationCompteCommand(String pseudo, Deck deck) {
        this.pseudo = pseudo;
        this.deck = deck;
        nbr_jetons = 4;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Deck getDeck() {
        return deck;
    }

}
