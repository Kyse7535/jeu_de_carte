package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Rarete {

    Commun(0),
    Rare(10),
    Legandaire(20);

    @JsonProperty
    public float procentage;

    private Rarete(float procentage) {
        this.procentage = procentage;
    }
    Rarete() {}
}
