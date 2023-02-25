package adapter.out.database.Mapper;

import adapter.out.database.Entity.CombatEntity;
import adapter.out.database.Entity.HerosEntity;
import domain.Combat;
import domain.Heros;

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
