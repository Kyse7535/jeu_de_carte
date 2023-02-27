package src.client.rest_adapter.resource;

import src.client.rest_adapter.dto.*;
import src.domain.functional.DTOs.*;
import src.domain.functional.model.*;
import src.domain.ports.client.*;
import src.client.rest_adapter.mapper.CaracteristiquesDtoMapper;
import src.client.rest_adapter.mapper.CombatDtoMapper;
import src.client.rest_adapter.mapper.CompteDtoMapper;
import src.client.rest_adapter.mapper.HerosDtoMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public final class CompteController {
    private final CreationCompteUseCase creationCompteUseCase;
    private final RechercheJoueursUseCase rechercheJoueursUseCase;
    private final CreationHerosUseCase creationHerosUseCase;
    private final RechercheUnHerosUseCase rechercheUnHerosUseCase;
    private final RechercheUnJoueurUseCase rechercheUnJoueurUseCase;
    private final RechercheHerosDispoUseCase rechercheHerosDispoUseCase;
    private final CombatUseCase combatUseCase;
    private final OuverturePackUseCase ouverturePackUseCase;
    private final RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase;



    public CompteController(CreationCompteUseCase creationCompteUseCase, RechercheJoueursUseCase rechercheJoueursUseCase, CombatUseCase combatUseCase,
                            CreationHerosUseCase creationHerosUseCase , RechercheUnHerosUseCase rechercheUnHerosUseCase,
                            OuverturePackUseCase ouverturePackUseCase, RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase,
                            RechercheUnJoueurUseCase rechercheUnJoueurUseCase, RechercheHerosDispoUseCase rechercheHerosDispoUseCase) {
        this.creationCompteUseCase = creationCompteUseCase;
        this.rechercheJoueursUseCase = rechercheJoueursUseCase;
        this.creationHerosUseCase = creationHerosUseCase;
        this.rechercheUnHerosUseCase = rechercheUnHerosUseCase;
        this.rechercheUnJoueurUseCase = rechercheUnJoueurUseCase;
        this.combatUseCase = combatUseCase;
        this.ouverturePackUseCase = ouverturePackUseCase;
        this.rechercheHistoryHeroUseCase = rechercheHistoryHeroUseCase;
        this.rechercheHerosDispoUseCase = rechercheHerosDispoUseCase;
    }

    @PostMapping("/create_account")
    public CompteDTO create_compte(@RequestBody @Valid CreationCompteDTO dto) {
        Compte compte = creationCompteUseCase.create(new CreationCompteCommand(dto.pseudo));
        return CompteDtoMapper.toDto(compte);
    }

    @GetMapping("/players")
    public List<CompteDTO> recherche_liste_joueur() {
        List<Compte> listeComptes = rechercheJoueursUseCase.rechercheListeJoueur();
        ArrayList<CompteDTO> listeComptesDTO = new ArrayList<>();
        for(Compte i : listeComptes) {
            CompteDTO compteDTO = CompteDtoMapper.toDto(i);
            listeComptesDTO.add(compteDTO);
        }
        return listeComptesDTO;
    }

    @PostMapping("/heros/create")
    public HerosDTO create_heros(@RequestBody @Valid HerosCreationDTO herosCreationDTO) {
        Caracteristiques caracteristiques = CaracteristiquesDtoMapper.toDomain(herosCreationDTO.caracteristiquesDto);
        Heros heros =  creationHerosUseCase.create(new CreationHerosCommand(caracteristiques));
        return HerosDtoMapper.toDto(heros);
    }

    @GetMapping("/comptes/{pseudo}")
    public CompteDTO recherche_un_compte(@PathVariable String pseudo) {
        Compte compte = rechercheUnJoueurUseCase.rechercheUnJoueur(new RechercheUnJoueurCommand(pseudo));
        return CompteDtoMapper.toDto(compte);
    }

    @GetMapping("/heros/{id}")
    public HerosDTO recherche_un_heros(@PathVariable String id) {
        Heros heros = rechercheUnHerosUseCase.rechercheHerosDispo(new RechercheUnHerosCommand(id));
        return HerosDtoMapper.toDto(heros);
    }

    @GetMapping("/heros")
    public List<HerosDTO> recherche_heros_dispo() {
        List<Heros> list = rechercheHerosDispoUseCase.rechercheListeHerosDispos();
        List<HerosDTO> new_list = new ArrayList<>();
        for(Heros heros : list) {
            new_list.add(HerosDtoMapper.toDto(heros));
        }
        return new_list;
    }

    @GetMapping("/{attaquant}/combat/{adversaire}")
    public HerosDTO combat(@PathVariable String attaquant, @PathVariable String adversaire){
        Combat combat = new Combat(
                rechercheUnHerosUseCase.rechercheHerosDispo(new RechercheUnHerosCommand(attaquant)),
                rechercheUnHerosUseCase.rechercheHerosDispo(new RechercheUnHerosCommand(adversaire))
        );

        combatUseCase.attack(new CombatCommand(combat));
        return HerosDtoMapper.toDto(combat.getGagnant());
    }

    @GetMapping("/{pseudo}/open_pack/{pack}")
    public ArrayList<HerosDTO> ouverture_pack(@PathVariable String pseudo,@PathVariable String pack) {
        Compte compte = rechercheUnJoueurUseCase.rechercheUnJoueur(new RechercheUnJoueurCommand(pseudo));
        ArrayList<Heros> liste_cartes =  ouverturePackUseCase.ouvrePack(new OuverturePackCommand(Pack.valueOf(pack), compte));
        ArrayList<HerosDTO> listeCartesDTO = new ArrayList<>();
        for(Heros i : liste_cartes) {
            listeCartesDTO.add(HerosDtoMapper.toDto(i));
        }
        return listeCartesDTO;

    }

    @GetMapping("/{heros_id}/history")
    public ArrayList<CombatDTO> combat_history(@PathVariable String heros_id) {
        List<Combat> listeCombat = rechercheHistoryHeroUseCase.combatHistory(new RechercheHistoryHeroCommand(heros_id));
        ArrayList<CombatDTO> listeCombatDTO = new ArrayList<>();
        for(Combat i : listeCombat) {
            listeCombatDTO.add(CombatDtoMapper.toDto(i));
        }
        return listeCombatDTO;
    }

}
