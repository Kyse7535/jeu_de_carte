package application.services;

import application.port.in.DTOs.RechercheHistoryHeroCommand;
import application.port.in.UseCases.RechercheHistoryHeroUseCase;
import application.port.out.HerosRepository;
import domain.Combat;

import java.util.ArrayList;

public class RechercheHistoryHeroService implements RechercheHistoryHeroUseCase {

    private final HerosRepository repository;

    public RechercheHistoryHeroService(HerosRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Combat> combat_history(RechercheHistoryHeroCommand rechercheHistoryHeroCommand) {
        return repository.load_heros(rechercheHistoryHeroCommand.getHeros().getId()).get_history();
    }
}
