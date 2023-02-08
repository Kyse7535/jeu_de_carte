package adapter.mapper;

import adapter.in.DeckDto;
import adapter.in.HerosDTO;
import domain.Deck;
import domain.Heros;

import java.util.ArrayList;

public interface DeckDtoMapper {
    static Deck toDomain(DeckDto dto) {
        ArrayList<Heros> listHeros = new ArrayList<>();
        for (HerosDTO i : dto.listCartes) {
            Heros heros = HerosDtoMapper.toDomain(i);
            listHeros.add(heros);
        }
        return new Deck(listHeros);
    }

    static DeckDto toDto(Deck deck) {
        ArrayList<HerosDTO> listHeros = new ArrayList<>();
        for (Heros i : deck.getListCartes()) {
            HerosDTO heros = HerosDtoMapper.toDto(i);
            listHeros.add(heros);
        }
        return new DeckDto(listHeros);
    }
}
