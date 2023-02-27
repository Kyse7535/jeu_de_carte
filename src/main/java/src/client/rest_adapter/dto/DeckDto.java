package src.client.rest_adapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DeckDto {
    @JsonProperty
    public ArrayList<HerosDTO> listCartes;

    public DeckDto() {
        this.listCartes = new ArrayList<>();
    }

    public DeckDto(ArrayList<HerosDTO> listCartes) {
        this.listCartes = listCartes;
    }

    @Override
    public String toString() {
        return "DeckDto{" +
                "listCartes=" + listCartes +
                '}';
    }
}
