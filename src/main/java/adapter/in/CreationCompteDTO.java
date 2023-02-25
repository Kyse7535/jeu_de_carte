package adapter.in;

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
