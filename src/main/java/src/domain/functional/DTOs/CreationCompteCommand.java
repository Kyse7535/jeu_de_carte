package src.domain.functional.DTOs;

import src.domain.functional.model.Deck;

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
