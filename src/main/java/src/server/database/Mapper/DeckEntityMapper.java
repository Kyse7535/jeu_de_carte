package src.server.database.Mapper;

import src.server.database.Entity.DeckEntity;
import src.server.database.Entity.HerosEntity;
import src.domain.functional.model.Deck;
import src.domain.functional.model.Heros;

import java.util.ArrayList;

public interface DeckEntityMapper {
    static Deck toDomain(DeckEntity entity) {
        ArrayList<Heros> listHeros = new ArrayList<>();
        for (HerosEntity i : entity.listCartes) {
            Heros heros = HerosEntityMapper.toDomain(i);
            listHeros.add(heros);
        }
        return new Deck(listHeros);
    }

    static DeckEntity toEntity(Deck deck) {
        ArrayList<HerosEntity> listHeros = new ArrayList<>();
        for (Heros i : deck.getListCartes()) {
            HerosEntity heros = HerosEntityMapper.toEntity(i);
            listHeros.add(heros);
        }
        return new DeckEntity(listHeros);
    }
}
