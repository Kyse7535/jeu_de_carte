package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Deck {
    @JsonProperty
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
