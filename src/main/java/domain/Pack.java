package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Pack {
    argent(1, 3),
    diamant(2, 5);

    @JsonProperty
    public int prix;
    @JsonProperty
    public int nbr_cartes;
    //private final Quartet<Integer, Integer, Integer> probabilites;
    private Pack(int prix, int nbr_cartes /*Quartet<Integer, Integer, Integer> probabilites*/) {
        this.prix = prix;
        this.nbr_cartes = nbr_cartes;
        //this.probabilites = probabilites;
    }
    Pack() {}
}
