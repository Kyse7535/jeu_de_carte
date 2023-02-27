package src.domain.functional.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Rarete {

    Commun(0),
    Rare(10),
    Legandaire(20);


    private float procentage;

    public float getProcentage() {
        return procentage;
    }

    Rarete(float procentage) {
        this.procentage = procentage;
    }

}
