package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RareteDto {

    Commun(0),
    Rare(10),
    Legandaire(20);

    @JsonProperty
    public float procentage;

    private RareteDto(float procentage) {
        this.procentage = procentage;
    }
    RareteDto() {}

    @Override
    public String toString() {
        return "RareteDto{" +
                "procentage=" + procentage +
                '}';
    }
}