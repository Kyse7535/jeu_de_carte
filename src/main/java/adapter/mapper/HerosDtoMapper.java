package adapter.mapper;

import adapter.in.CombatDTO;
import adapter.in.HerosDTO;
import domain.Combat;
import domain.Heros;

import java.util.ArrayList;

public interface HerosDtoMapper {
    static Heros toDomain(HerosDTO dto) {
        ArrayList<Combat> history = new ArrayList<>();
        for(CombatDTO combat : dto.combatHistory) {
            history.add(CombatDtoMapper.toDomain(combat));
        }
        return new Heros(
                dto.id,
                CaracteristiquesDtoMapper.toDomain(dto.caracteristiques),
                dto.niveau,
                dto.pointDeVie,
                dto.pointExp,
                dto.puissance,
                dto.armure,
                dto.puissanceSupplementaire,
                history,
                dto.en_vie
        );
    }

    static HerosDTO toDto(Heros heros) {
        ArrayList<CombatDTO> history = new ArrayList<>();
        for(Combat combat : heros.getHistory()) {
            history.add(CombatDtoMapper.toDto(combat));
        }
        return new HerosDTO(
                heros.getId(),
                CaracteristiquesDtoMapper.toDto(heros.getCaracteristiques()),
                heros.getNiveau(),
                heros.getPointDeVie(),
                heros.getPointExp(),
                heros.getPuissance(),
                heros.getArmure(),
                heros.getPuissanceSupplementaire(),
                history,
                heros.getEnVie()
        );
    }
}


