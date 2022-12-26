package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Caracteristiques {

    @JsonProperty
    private Specialite specialite;
    @JsonProperty
    private Rarete rarete;

    public Caracteristiques(Specialite specialite, Rarete rarete) {
        this.specialite = specialite;
        this.rarete = rarete;
    }

    Caracteristiques() {};

    public Specialite getSpecialite() {
        return specialite;
    }

    public Rarete getRarete() {
        return rarete;
    }
}
