package src.client.rest_adapter.mapper;

import src.client.rest_adapter.dto.CaracteristiquesDto;
import src.client.rest_adapter.dto.RareteDto;
import src.client.rest_adapter.dto.SpecialiteDto;
import src.domain.functional.model.Caracteristiques;
import src.domain.functional.model.Rarete;
import src.domain.functional.model.Specialite;

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
