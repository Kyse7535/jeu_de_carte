package domain;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Heros> listCartes;

    public Deck() {
        this.listCartes = new ArrayList<>();
    }

    public void ajouteCarte(Heros heros) {
        listCartes.add(heros);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "listCartes=" + listCartes +
                '}';
    }
}
