import adapter.in.*;
import adapter.out.database.Adapter.MysqlAdapter;
import application.port.in.UseCases.*;
import application.services.*;

import java.util.ArrayList;

public class ApplicationMain {
    public static void main(String[] args) {
/*
        MysqlAdapter persistanceAdapter = new MysqlAdapter(compteRepository);

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


        CompteDTO compte1 = compteController.create_compte(new CreationCompteDTO("test"));
        CompteDTO compte2 = compteController.create_compte(new CreationCompteDTO("test2"));
        ArrayList<CompteDTO> list = compteController.recherche_liste_joueur();
        System.out.println(list);

        HerosDTO heros1= compteController.create_heros(
                new HerosCreationDTO(new CaracteristiquesDto(SpecialiteDto.Tank, RareteDto.Rare)));
        HerosDTO heros2= compteController.create_heros(
                new HerosCreationDTO(new CaracteristiquesDto(SpecialiteDto.Tank, RareteDto.Rare)));

        System.out.println(persistanceAdapter.findAllHeros());

        compte1.deck.listCartes.add(heros1);
        compte1.deck.listCartes.add(heros2);

        compteController.combat(heros1.id,heros2.id);
        compteController.ouverture_pack(compte1.pseudo,"argent");
        compteController.ouverture_pack(compte2.pseudo,"argent");

        System.out.println(persistanceAdapter.findAllHeros());
        System.out.println(heros1.combatHistory);
        System.out.println(list);

 */
    }



}
