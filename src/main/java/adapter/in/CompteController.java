package adapter.in;

import application.port.in.DTOs.*;
import application.port.in.UseCases.*;
import application.port.out.CompteRepository;
import domain.*;

import java.util.ArrayList;

public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;
    private final RechercheJoueursUseCase rechercheJoueursUseCase;
    private final CombatUseCase combatUseCase;
    private final CreationHerosUseCase creationHerosUseCase;
    private final RechercheHerosUseCase rechercheHerosUseCase;
    private final OuverturePackUseCase ouverturePackUseCase;


    public CompteController(CreationCompteUseCase creationCompteUseCase, RechercheJoueursUseCase rechercheJoueursUseCase, CombatUseCase combatUseCase, CreationHerosUseCase creationHerosUseCase, RechercheHerosUseCase rechercheHerosUseCase, OuverturePackUseCase ouverturePackUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
        this.rechercheJoueursUseCase = rechercheJoueursUseCase;
        this.combatUseCase = combatUseCase;
        this.creationHerosUseCase = creationHerosUseCase;
        this.rechercheHerosUseCase = rechercheHerosUseCase;
        this.ouverturePackUseCase = ouverturePackUseCase;
    }

    public Compte create_compte(String pseudo) {
        return creationCompteUseCase.create(new CreationCompteCommand(pseudo));
    }

    public ArrayList<Compte> recherche_liste_joueur(CompteRepository repository) {
        return rechercheJoueursUseCase.recherche_liste_joueur(new RechercheJoueursCommand(repository));
    }

    public void combat(Heros attaquant, Heros adversaire) {
        Combat combat = new Combat(attaquant,adversaire);
        combatUseCase.attack(new CombatCommand(combat));
    }

    public Heros create_heros(Specialite specialite, Rarete rarete) {
        return creationHerosUseCase.create(new CreationHerosCommand(specialite,rarete));
    }

    public ArrayList<Heros> recherche_heros(Compte compte) {
        return rechercheHerosUseCase.recherche_heros_dispo(new RechercheHerosCommand(compte));
    }

    public ArrayList<Heros> ouverture_pack(Compte compte, Pack pack) {
        ArrayList<Heros> liste_cartes =  ouverturePackUseCase.ouvre_pack(new OuverturePackCommand(pack, compte));
        for(Heros i : liste_cartes) {
            compte.getDeck().ajouteCarte(i);
        }
        return liste_cartes;
    }


}
