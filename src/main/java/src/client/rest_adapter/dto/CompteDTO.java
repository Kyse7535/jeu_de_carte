package src.client.rest_adapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompteDTO {
    @JsonProperty
    public String pseudo;
    @JsonProperty
    public int nombreJetons;
    @JsonProperty
    public DeckDto deck;


    public CompteDTO(String pseudo, int nombreJetons, DeckDto deck) {
        this.pseudo = pseudo;
        this.nombreJetons = nombreJetons;
        this.deck = deck;
    }

    CompteDTO() {}

    @Override
    public String toString() {
        return "CompteDTO{" +
                "pseudo='" + pseudo + '\'' +
                ", nombre_jetons=" + nombreJetons +
                ", deck=" + deck +
                '}';
    }
}
