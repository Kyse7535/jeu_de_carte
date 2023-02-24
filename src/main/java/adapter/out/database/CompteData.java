package adapter.out.database;

import javax.persistence.*;

@Entity
public class CompteData {

    @Id
    private String pseudo;
    private int nombreJetons;

    @Embedded
    private DeckData deck;


    public CompteData(String pseudo) {
        this.pseudo = pseudo;
        this.nombreJetons = 4;
        this.deck = new DeckData();
    }

    public CompteData(String pseudo, int nombreJetons, DeckData deck) {
        this.pseudo = pseudo;
        this.nombreJetons = nombreJetons;
        this.deck = deck;
    }

    public CompteData() {

    }

    public DeckData getDeck() {
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
