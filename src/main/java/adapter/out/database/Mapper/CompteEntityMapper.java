package adapter.out.database.Mapper;

import adapter.in.CompteDTO;
import adapter.mapper.DeckDtoMapper;
import adapter.out.database.Entity.CompteEntity;
import domain.Compte;

public interface CompteEntityMapper {

    static Compte toDomain(CompteEntity entity) {
        return new Compte(entity.pseudo,entity.nombreJetons, DeckEntityMapper.toDomain(entity.deck));
    }

    static CompteEntity toEntity(Compte compte) {
        return new CompteEntity(compte.getPseudo(),compte.getNombreJetons(),DeckEntityMapper.toEntity(compte.getDeck()));
    }
}
