package adapter.out.database.Mapper;

import adapter.in.DeckDto;
import adapter.in.HerosDTO;
import adapter.mapper.HerosDtoMapper;
import adapter.out.database.Entity.DeckEntity;
import adapter.out.database.Entity.HerosEntity;
import domain.Deck;
import domain.Heros;

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
