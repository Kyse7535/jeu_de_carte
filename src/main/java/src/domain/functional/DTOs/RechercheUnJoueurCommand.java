package src.domain.functional.DTOs;

public class RechercheUnJoueurCommand {
    private final String pseudo;

    public RechercheUnJoueurCommand(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }
}
