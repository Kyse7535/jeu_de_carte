package domain;

public class Compte {
    private final String pseudo;
    private int nombre_jetons;
    private Deck deck;


    public Compte(String pseudo) {
        this.pseudo = pseudo;
        this.nombre_jetons = 4;
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public String getPseudo() {
        return pseudo;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pseudo='" + pseudo + '\'' +
                ", nombre_jetons=" + nombre_jetons +
                ", deck=" + deck +
                '}';
    }
}
