package application.port.in.DTOs;

import domain.Deck;

public class CreationCompteCommand {
    public final String pseudo;
    public int nombre_jetons;
    public Deck deck;

    public CreationCompteCommand(String pseudo, Deck deck) {
        this.pseudo = pseudo;
        this.deck = deck;
        this.nombre_jetons = 4;
    }
}
