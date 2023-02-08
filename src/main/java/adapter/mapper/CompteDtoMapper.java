package adapter.mapper;

import adapter.in.CompteDTO;
import domain.Compte;

public interface CompteDtoMapper {
    static Compte toDomain(CompteDTO dto) {
        return new Compte(dto.pseudo,dto.nombreJetons,DeckDtoMapper.toDomain(dto.deck));
    }

    static CompteDTO toDto(Compte compte) {
        return new CompteDTO(compte.getPseudo(),compte.getNombreJetons(),DeckDtoMapper.toDto(compte.getDeck()));
    }
}
