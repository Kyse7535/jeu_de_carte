package adapter.out.database.Mapper;

import adapter.out.database.Entity.CaracteristiquesEntity;
import adapter.out.database.Entity.RareteEntity;
import adapter.out.database.Entity.SpecialiteEntity;
import domain.Caracteristiques;
import domain.Rarete;
import domain.Specialite;

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
