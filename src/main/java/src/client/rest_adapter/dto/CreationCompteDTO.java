package src.client.rest_adapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CreationCompteDTO {
    @JsonProperty
    public String pseudo;

    public CreationCompteDTO() {
    }

    public CreationCompteDTO(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "CreationCompteDTO{" +
                "pseudo='" + pseudo + '\'' +
                '}';
    }
}
