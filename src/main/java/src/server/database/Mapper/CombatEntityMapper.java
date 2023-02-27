package src.server.database.Mapper;

import src.server.database.Entity.CombatEntity;
import src.domain.functional.model.Combat;

public interface CombatEntityMapper {
    static Combat toDomain(CombatEntity entity) {
        return new Combat(HerosEntityMapper.toDomain(entity.getAttaquant()),HerosEntityMapper.toDomain(entity.getAdversaire()));
    }

    static CombatEntity toEntity(Combat combat) {
        return new CombatEntity(HerosEntityMapper.toEntity(combat.getAttaquant()), HerosEntityMapper.toEntity(combat.getAdversaire()));
    }
}
