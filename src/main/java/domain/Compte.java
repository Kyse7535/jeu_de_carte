package domain;

public class Compte {

    private String pseudo;
    private int nombreJetons;
    private Deck deck;


    public Compte(String pseudo) {
        this.pseudo = pseudo;
        this.nombreJetons = 4;
        this.deck = new Deck();
    }

    public Compte(String pseudo, int nombreJetons, Deck deck) {
        this.pseudo = pseudo;
        this.nombreJetons = nombreJetons;
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getNombreJetons() {
        return nombreJetons;
    }

    public void diminueNombre_jetons(int nombre_jetons) {
        this.nombreJetons -= nombre_jetons;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pseudo='" + pseudo + '\'' +
                ", nombre_jetons=" + nombreJetons +
                ", deck=" + deck +
                '}';
    }
}
