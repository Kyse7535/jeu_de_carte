package domain;

public class Joueur {
    private final String pseudo;
    private int nombre_jetons;
    private Deck deck;
    public Joueur(String pseudo, Deck deck) {
        this.pseudo = pseudo;
        this.nombre_jetons = 4;
        this.deck = new Deck();
    }

}
