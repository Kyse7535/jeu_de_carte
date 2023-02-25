package adapter.out.database.Mapper;

import adapter.in.CombatDTO;
import adapter.mapper.HerosDtoMapper;
import adapter.out.database.Entity.CombatEntity;
import domain.Combat;

public interface CombatEntityMapper {
    static Combat toDomain(CombatEntity entity) {
        return new Combat(HerosEntityMapper.toDomain(entity.getAttaquant()),HerosEntityMapper.toDomain(entity.getAdversaire()));
    }

    static CombatEntity toEntity(Combat combat) {
        return new CombatEntity(HerosEntityMapper.toEntity(combat.getAttaquant()), HerosEntityMapper.toEntity(combat.getAdversaire()));
    }
}
