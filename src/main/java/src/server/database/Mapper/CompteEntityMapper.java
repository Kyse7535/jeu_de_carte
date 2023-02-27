package src.server.database.Mapper;

import src.server.database.Entity.CompteEntity;
import src.domain.functional.model.Compte;

public interface CompteEntityMapper {

    static Compte toDomain(CompteEntity entity) {
        return new Compte(entity.pseudo,entity.nombreJetons, DeckEntityMapper.toDomain(entity.deck));
    }

    static CompteEntity toEntity(Compte compte) {
        return new CompteEntity(compte.getPseudo(),compte.getNombreJetons(),DeckEntityMapper.toEntity(compte.getDeck()));
    }
}
