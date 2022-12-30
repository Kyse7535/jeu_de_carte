package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Pack {
    argent(1, 3, new int[]{5, 20, 75}),
    diamant(2, 5, new int[]{15,35,5});

    @JsonProperty
    public int prix;
    @JsonProperty
    public int nbr_cartes;
    private int[] probabilites = {};

    private Pack(int prix, int nbr_cartes, int[] probabilites) {
        this.prix = prix;
        this.nbr_cartes = nbr_cartes;
        this.probabilites = probabilites;
    }

    public int[] getProbabilites() {
        return probabilites;
    }

    Pack() {}

}
