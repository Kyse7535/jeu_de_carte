import adapter.in.CompteController;
import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.*;
import application.services.*;
import domain.*;

import java.util.ArrayList;

public class ApplicationMain {
    public static void main(String[] args) {

        PersistanceAdapter persistanceAdapter = new PersistanceAdapter();

        CreationCompteUseCase creationCompteUseCase = new CreationCompteService(persistanceAdapter);
        RechercheJoueursUseCase rechercheJoueursUseCase = new RechercheJoueursService(persistanceAdapter);
        CombatUseCase combatUseCase = new CombatService(persistanceAdapter);
        CreationHerosUseCase creationHerosUseCase = new CreationHerosService(persistanceAdapter);
        RechercheHerosUseCase rechercheHerosUseCase = new RechercheHerosService(persistanceAdapter);
        OuverturePackUseCase ouverturePackUseCase = new OuverturePackService(new CreationHerosService(persistanceAdapter), persistanceAdapter);
        RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase = new RechercheHistoryHeroService(persistanceAdapter);
        RechercheUnJoueurUseCase rechercheUnJoueurUseCase = new RechercheUnJoueurService(persistanceAdapter);
        CompteController compteController = new CompteController(creationCompteUseCase,rechercheJoueursUseCase, combatUseCase, creationHerosUseCase, rechercheHerosUseCase, ouverturePackUseCase, rechercheHistoryHeroUseCase,
                rechercheUnJoueurUseCase);


        Compte compte1 = compteController.create_compte("test");
        Compte compte2 = compteController.create_compte("test2");
        ArrayList<Compte> list = compteController.recherche_liste_joueur(persistanceAdapter);
        System.out.println(list);

        Heros heros1= compteController.create_heros(new Caracteristiques(Specialite.Tank, Rarete.Rare));
        Heros heros2= compteController.create_heros(new Caracteristiques(Specialite.Tank, Rarete.Rare));

        System.out.println(persistanceAdapter.findAllHeros());

        compte1.getDeck().ajouteCarte(heros1);
        compte1.getDeck().ajouteCarte(heros2);

        compteController.combat(heros1.getId(),heros2.getId());
        compteController.ouverture_pack(compte1.getPseudo(),"argent");
        compteController.ouverture_pack(compte2.getPseudo(),"argent");

        System.out.println(persistanceAdapter.findAllHeros());
        System.out.println(heros1.get_history());
        System.out.println(list);
    }

}
