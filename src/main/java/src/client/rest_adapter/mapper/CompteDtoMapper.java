package src.client.rest_adapter.mapper;

import src.client.rest_adapter.dto.CompteDTO;
import src.domain.functional.model.Compte;

public interface CompteDtoMapper {
    static Compte toDomain(CompteDTO dto) {
        return new Compte(dto.pseudo,dto.nombreJetons,DeckDtoMapper.toDomain(dto.deck));
    }

    static CompteDTO toDto(Compte compte) {
        return new CompteDTO(compte.getPseudo(),compte.getNombreJetons(),DeckDtoMapper.toDto(compte.getDeck()));
    }
}
