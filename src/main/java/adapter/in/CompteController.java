package adapter.in;

import application.port.in.DTOs.*;
import application.port.in.UseCases.*;
import application.port.out.CompteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;
    private final RechercheJoueursUseCase rechercheJoueursUseCase;
    private final CombatUseCase combatUseCase;
    private final CreationHerosUseCase creationHerosUseCase;
    private final RechercheHerosUseCase rechercheHerosUseCase;
    private final OuverturePackUseCase ouverturePackUseCase;
    private final RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase;
    private final RechercheUnJoueurUseCase rechercheUnJoueurUseCase;


    public CompteController(CreationCompteUseCase creationCompteUseCase, RechercheJoueursUseCase rechercheJoueursUseCase, CombatUseCase combatUseCase, CreationHerosUseCase creationHerosUseCase, RechercheHerosUseCase rechercheHerosUseCase, OuverturePackUseCase ouverturePackUseCase, RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase, RechercheUnJoueurUseCase rechercheUnJoueurUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
        this.rechercheJoueursUseCase = rechercheJoueursUseCase;
        this.combatUseCase = combatUseCase;
        this.creationHerosUseCase = creationHerosUseCase;
        this.rechercheHerosUseCase = rechercheHerosUseCase;
        this.ouverturePackUseCase = ouverturePackUseCase;
        this.rechercheHistoryHeroUseCase = rechercheHistoryHeroUseCase;
        this.rechercheUnJoueurUseCase = rechercheUnJoueurUseCase;
    }

    @PostMapping("/create_account")
    public Compte create_compte(@RequestBody @Valid String pseudo) {
        return creationCompteUseCase.create(new CreationCompteCommand(pseudo));
        // curl -X POST localhost:8080/create_account -H 'Content-type:application/json' -d 'gesco'
    }

    @GetMapping("/players")
    public ArrayList<Compte> recherche_liste_joueur(CompteRepository repository) {
        return rechercheJoueursUseCase.recherche_liste_joueur(new RechercheJoueursCommand(repository));
        // curl -v localhost:8080/players
    }

    @GetMapping("/heros/{id}")
    public Heros recherche_un_heros(@PathVariable String id) {
        return rechercheHerosUseCase.recherche_heros_dispo(new RechercheHerosCommand(id));
    }

    @GetMapping("/{attaquant}/combat/{adversaire}")
    public Heros combat(@PathVariable String attaquant, @PathVariable String adversaire){
        Combat combat = new Combat(
                rechercheHerosUseCase.recherche_heros_dispo(new RechercheHerosCommand(attaquant)),
                rechercheHerosUseCase.recherche_heros_dispo(new RechercheHerosCommand(adversaire))
        );

        combatUseCase.attack(new CombatCommand(combat));
        return combat.getGagnant();
        // curl -v localhost:8080/gesco/combat/gesco2
    }

    @PostMapping("/heros/create")
    public Heros create_heros(@RequestBody @Valid Caracteristiques caracteristiques) {
        return creationHerosUseCase.create(new CreationHerosCommand(caracteristiques));
        //curl -X POST localhost:8080/heros/create -H 'Content-type:application/json' -d '{"specialite": "Tank", "rarete": "Commun"}'
    }

    @GetMapping("/{pseudo}/open_pack/{pack}")
    public ArrayList<Heros> ouverture_pack(@PathVariable String pseudo,@PathVariable String pack) {
        Compte compte = rechercheUnJoueurUseCase.recherche_un_joueur(new RechercheUnJoueurCommand(pseudo));
        ArrayList<Heros> liste_cartes =  ouverturePackUseCase.ouvre_pack(new OuverturePackCommand(Pack.valueOf(pack), compte));
        for(Heros i : liste_cartes) {
            compte.getDeck().ajouteCarte(i);
        }
        return liste_cartes;
        // curl -v localhost:8080/gesco/open_pack/argent

    }


    public ArrayList<Combat> combat_history(Heros heros) {
        return rechercheHistoryHeroUseCase.combat_history(new RechercheHistoryHeroCommand(heros));
    }


}
