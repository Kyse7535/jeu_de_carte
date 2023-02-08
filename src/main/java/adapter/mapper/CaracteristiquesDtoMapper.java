package adapter.mapper;

import adapter.in.CaracteristiquesDto;
import adapter.in.RareteDto;
import adapter.in.SpecialiteDto;
import domain.Caracteristiques;
import domain.Rarete;
import domain.Specialite;

public interface CaracteristiquesDtoMapper {
    static Caracteristiques toDomain(CaracteristiquesDto dto) {
        Specialite specialite = Specialite.valueOf(dto.getSpecialite().name());
        Rarete rarete = Rarete.valueOf(dto.getRarete().name());
        return new Caracteristiques(specialite,rarete);
    }

    static CaracteristiquesDto toDto(Caracteristiques caracteristiques) {
        SpecialiteDto specialiteDto = SpecialiteDto.valueOf(caracteristiques.getSpecialite().name());
        RareteDto rareteDto = RareteDto.valueOf(caracteristiques.getRarete().name());
        return new CaracteristiquesDto(specialiteDto,rareteDto);
    }
}
