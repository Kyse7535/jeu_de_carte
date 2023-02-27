package src.server.database.Mapper;

import src.server.database.Entity.CaracteristiquesEntity;
import src.server.database.Entity.RareteEntity;
import src.server.database.Entity.SpecialiteEntity;
import src.domain.functional.model.Caracteristiques;
import src.domain.functional.model.Rarete;
import src.domain.functional.model.Specialite;

public interface CaracteristiquesEntityMapper {
    static Caracteristiques toDomain(CaracteristiquesEntity entity) {
        Specialite specialite = Specialite.valueOf(entity.getSpecialite().name());
        Rarete rarete = Rarete.valueOf(entity.getRarete().name());
        return new Caracteristiques(specialite,rarete);
    }

    static CaracteristiquesEntity toEntity(Caracteristiques caracteristiques) {
        SpecialiteEntity specialiteEntity = SpecialiteEntity.valueOf(caracteristiques.getSpecialite().name());
        RareteEntity rareteEntity = RareteEntity.valueOf(caracteristiques.getRarete().name());
        return new CaracteristiquesEntity(specialiteEntity,rareteEntity);
    }
}
