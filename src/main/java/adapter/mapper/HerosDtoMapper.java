package adapter.mapper;

import adapter.in.HerosDTO;
import domain.Heros;

public interface HerosDtoMapper {
    static Heros toDomain(HerosDTO dto) {
        return new Heros(
                dto.id,
                CaracteristiquesDtoMapper.toDomain(dto.caracteristiques),
                dto.niveau,
                dto.pointDeVie,
                dto.pointExp,
                dto.puissance,
                dto.armure,
                dto.puissanceSupplementaire,
                dto.combatHistory,
                dto.en_vie
        );
    }

    static HerosDTO toDto(Heros heros) {
        return new HerosDTO(
                heros.getId(),
                CaracteristiquesDtoMapper.toDto(heros.getCaracteristiques()),
                heros.getNiveau(),
                heros.getPointDeVie(),
                heros.getPointExp(),
                heros.getPuissance(),
                heros.getArmure(),
                heros.getPuissanceSupplementaire(),
                heros.getHistory(),
                heros.getEnVie()
        );
    }
}


