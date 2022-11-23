package domain;

public class Compte {
    private final String pseudo;
    private int nombre_jetons;
    private Deck deck;


    public Compte(String pseudo, Deck deck) {
        this.pseudo = pseudo;
        this.nombre_jetons = 4;
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

}
