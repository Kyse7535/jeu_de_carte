package src.domain.functional.DTOs;

import src.domain.functional.model.Compte;
import src.domain.functional.model.Pack;

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
