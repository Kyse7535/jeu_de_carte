package src.domain.functional.model;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Heros> listCartes;

    public Deck() {
        this.listCartes = new ArrayList<>();
    }

    public Deck(ArrayList<Heros> listCartes) { this.listCartes = listCartes;}

    public ArrayList<Heros> getListCartes() {
        return listCartes;
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
