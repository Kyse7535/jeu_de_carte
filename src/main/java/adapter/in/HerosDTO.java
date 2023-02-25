package adapter.in;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class HerosDTO {
    @JsonProperty
    public String id;
    @JsonProperty
    public CaracteristiquesDto caracteristiques;
    @JsonProperty
    public float niveau;
    @JsonProperty
    public float pointDeVie;
    @JsonProperty
    public float pointExp;
    @JsonProperty
    public float puissance;
    @JsonProperty
    public float armure;
    @JsonProperty
    public float puissanceSupplementaire;
    @JsonIgnore
    public ArrayList<CombatDTO> combatHistory;
    public boolean en_vie;

    public HerosDTO(String id, CaracteristiquesDto caracteristiques, float niveau, float pointDeVie, float pointExp, float puissance, float armure, float puissanceSupplementaire, ArrayList<CombatDTO> combatHistory, boolean en_vie) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.niveau = niveau;
        this.pointDeVie = pointDeVie;
        this.pointExp = pointExp;
        this.puissance = puissance;
        this.armure = armure;
        this.puissanceSupplementaire = puissanceSupplementaire;
        this.combatHistory = combatHistory;
        this.en_vie = en_vie;
    }

    @Override
    public String toString() {
        return "HerosDTO{" +
                "id='" + id + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", niveau=" + niveau +
                ", point_de_vie=" + pointDeVie +
                ", point_exp=" + pointExp +
                ", puissance=" + puissance +
                ", armure=" + armure +
                ", puissance_supplementaire=" + puissanceSupplementaire +
                ", combat_history=" + combatHistory +
                ", en_vie=" + en_vie +
                '}';
    }
}
