package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Compte {
    @JsonProperty
    private String pseudo;
    @JsonProperty
    private int nombre_jetons;
    @JsonProperty
    private Deck deck;


    public Compte(String pseudo) {
        this.pseudo = pseudo;
        this.nombre_jetons = 4;
        this.deck = new Deck();
    }

    Compte() {}

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
