package application.port.in.DTOs;

public class RechercheUnJoueurCommand {
    private final String pseudo;

    public RechercheUnJoueurCommand(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }
}
