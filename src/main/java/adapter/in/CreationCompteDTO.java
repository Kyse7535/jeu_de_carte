package adapter.in;

public final class CreationCompteDTO {
        public final String pseudo;

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
