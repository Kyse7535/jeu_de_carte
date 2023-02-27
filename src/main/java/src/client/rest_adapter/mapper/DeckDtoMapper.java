package src.client.rest_adapter.mapper;

import src.client.rest_adapter.dto.DeckDto;
import src.client.rest_adapter.dto.HerosDTO;
import src.domain.functional.model.Deck;
import src.domain.functional.model.Heros;

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
