package adapter.in;

import adapter.mapper.CaracteristiquesDtoMapper;
import adapter.mapper.CombatDtoMapper;
import adapter.mapper.CompteDtoMapper;
import adapter.mapper.HerosDtoMapper;
import application.port.in.DTOs.*;
import application.port.in.UseCases.*;
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
    public CompteDTO create_compte(@RequestBody @Valid CreationCompteDTO dto) {
        Compte compte = creationCompteUseCase.create(new CreationCompteCommand(dto.pseudo));
        return CompteDtoMapper.toDto(compte);
        // curl -X POST localhost:8080/create_account -H 'Content-type:application/json' -d 'gesco'
    }

    @GetMapping("/players")
    public ArrayList<CompteDTO> recherche_liste_joueur() {
        ArrayList<Compte> listeComptes = rechercheJoueursUseCase.rechercheListeJoueur();
        ArrayList<CompteDTO> listeComptesDTO = new ArrayList<>();
        for(Compte i : listeComptes) {
            CompteDTO compteDTO = CompteDtoMapper.toDto(i);
            listeComptesDTO.add(compteDTO);
        }
        return listeComptesDTO;
        // curl -v localhost:8080/players
    }

    @GetMapping("/heros/{id}")
    public HerosDTO recherche_un_heros(@PathVariable String id) {
        Heros heros = rechercheHerosUseCase.rechercheHerosDispo(new RechercheHerosCommand(id));
        return HerosDtoMapper.toDto(heros);
    }

    @GetMapping("/{attaquant}/combat/{adversaire}")
    public HerosDTO combat(@PathVariable String attaquant, @PathVariable String adversaire){
        Combat combat = new Combat(
                rechercheHerosUseCase.rechercheHerosDispo(new RechercheHerosCommand(attaquant)),
                rechercheHerosUseCase.rechercheHerosDispo(new RechercheHerosCommand(adversaire))
        );

        combatUseCase.attack(new CombatCommand(combat));
        return HerosDtoMapper.toDto(combat.getGagnant());
        // curl -v localhost:8080/gesco/combat/gesco2
    }

    @PostMapping("/heros/create")
    public HerosDTO create_heros(@RequestBody @Valid HerosCreationDTO herosCreationDTO) {
        Caracteristiques caracteristiques = CaracteristiquesDtoMapper.toDomain(herosCreationDTO.caracteristiquesDto);
        Heros heros =  creationHerosUseCase.create(new CreationHerosCommand(caracteristiques));
        return HerosDtoMapper.toDto(heros);
        //curl -X POST localhost:8080/heros/create -H 'Content-type:application/json' -d '{"specialite": "Tank", "rarete": "Commun"}'
    }

    @GetMapping("/{pseudo}/open_pack/{pack}")
    public ArrayList<HerosDTO> ouverture_pack(@PathVariable String pseudo,@PathVariable String pack) {
        Compte compte = rechercheUnJoueurUseCase.rechercheUnJoueur(new RechercheUnJoueurCommand(pseudo));
        ArrayList<Heros> liste_cartes =  ouverturePackUseCase.ouvrePack(new OuverturePackCommand(Pack.valueOf(pack), compte));
        ArrayList<HerosDTO> listeCartesDTO = new ArrayList<>();
        for(Heros i : liste_cartes) {
            compte.getDeck().ajouteCarte(i);
            listeCartesDTO.add(HerosDtoMapper.toDto(i));
        }
        return listeCartesDTO;
        // curl -v localhost:8080/gesco/open_pack/argent

    }


    public ArrayList<CombatDTO> combat_history(String id) {
        ArrayList<Combat> listeCombat = rechercheHistoryHeroUseCase.combatHistory(new RechercheHistoryHeroCommand(id));
        ArrayList<CombatDTO> listeCombatDTO = new ArrayList<>();
        for(Combat i : listeCombat) {
            listeCombatDTO.add(CombatDtoMapper.toDto(i));
        }
        return listeCombatDTO;
    }


}
