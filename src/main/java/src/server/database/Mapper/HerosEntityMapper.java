package src.server.database.Mapper;

import src.server.database.Entity.CombatEntity;
import src.server.database.Entity.HerosEntity;
import src.domain.functional.model.Combat;
import src.domain.functional.model.Heros;

import java.util.ArrayList;

public interface HerosEntityMapper {
    static Heros toDomain(HerosEntity entity) {
        ArrayList<Combat> history = new ArrayList<>();
        for(CombatEntity combat : entity.combatHistory) {
            history.add(CombatEntityMapper.toDomain(combat));
        }
        return new Heros(
                entity.id,
                CaracteristiquesEntityMapper.toDomain(entity.caracteristiques),
                entity.niveau,
                entity.pointDeVie,
                entity.pointExp,
                entity.puissance,
                entity.armure,
                entity.puissanceSupplementaire,
                history,
                entity.enVie
        );
    }

    static HerosEntity toEntity(Heros heros) {
        ArrayList<CombatEntity> history = new ArrayList<>();
        for(Combat combat : heros.getHistory()) {
            history.add(CombatEntityMapper.toEntity(combat));
        }
        return new HerosEntity(
                heros.getId(),
                CaracteristiquesEntityMapper.toEntity(heros.getCaracteristiques()),
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
