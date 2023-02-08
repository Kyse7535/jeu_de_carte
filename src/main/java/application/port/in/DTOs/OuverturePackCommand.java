package application.port.in.DTOs;

import domain.Compte;
import domain.Pack;

public class OuverturePackCommand {
    private final Pack pack;
    private final Compte compte;

    public OuverturePackCommand(Pack pack, Compte compte) {
        this.pack = pack;
        this.compte = compte;
    }

    public Pack getPack() {
        return pack;
    }

    public Compte getCompte() {
        return compte;
    }
}
