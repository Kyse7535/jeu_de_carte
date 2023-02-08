package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;
public class CaracteristiquesDto {
    @JsonProperty
    private SpecialiteDto specialite;
    @JsonProperty
    private RareteDto rarete;

    public CaracteristiquesDto(SpecialiteDto specialite, RareteDto rarete) {
        this.specialite = specialite;
        this.rarete = rarete;
    }

    CaracteristiquesDto() {};

    public SpecialiteDto getSpecialite() {
        return specialite;
    }

    public RareteDto getRarete() {
        return rarete;
    }

    @Override
    public String toString() {
        return "Caracteristiques{" +
                "specialite=" + specialite +
                ", rarete=" + rarete +
                '}';
    }
}
