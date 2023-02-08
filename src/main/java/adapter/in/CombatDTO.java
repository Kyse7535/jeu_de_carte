package adapter.in;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CombatDTO {

    @JsonProperty
    public HerosDTO attaquant;
    @JsonProperty
    public  HerosDTO adversaire;
    @JsonProperty
    public boolean combatEnCours = true;
    @JsonProperty
    public HerosDTO gagnant;


    public CombatDTO(HerosDTO attaquant, HerosDTO adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }

    @Override
    public String toString() {
        return "CombatDTO{" +
                "attaquant=" + attaquant +
                ", adversaire=" + adversaire +
                ", combat_en_cours=" + combatEnCours +
                ", gagnant=" + gagnant +
                '}';
    }
}
