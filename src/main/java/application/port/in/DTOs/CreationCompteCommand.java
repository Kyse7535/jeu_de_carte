package application.port.in.DTOs;

import domain.Deck;

public class CreationCompteCommand {
    private final String pseudo;
    private Deck deck;
    private int nbrJetons;

    public CreationCompteCommand(String pseudo) {
        this.pseudo = pseudo;
        nbrJetons = 4;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Deck getDeck() {
        return deck;
    }

}
