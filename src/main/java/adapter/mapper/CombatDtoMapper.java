package adapter.mapper;

import adapter.in.CombatDTO;
import domain.Combat;

public interface CombatDtoMapper {
    static Combat toDomain(CombatDTO dto) {
        return new Combat(HerosDtoMapper.toDomain(dto.attaquant),HerosDtoMapper.toDomain(dto.adversaire));
    }

    static CombatDTO toDto(Combat combat) {
        return new CombatDTO(HerosDtoMapper.toDto(combat.getAttaquant()), HerosDtoMapper.toDto(combat.getAdversaire()));
    }
}
