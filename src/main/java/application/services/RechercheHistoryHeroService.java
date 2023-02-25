package application.services;

import application.port.in.DTOs.RechercheHistoryHeroCommand;
import application.port.in.UseCases.RechercheHistoryHeroUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Combat;

import java.util.ArrayList;

public class RechercheHistoryHeroService implements RechercheHistoryHeroUseCase {

    private final HerosPersistenceSpi repository;

    public RechercheHistoryHeroService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Combat> combatHistory(RechercheHistoryHeroCommand rechercheHistoryHeroCommand) {
        return repository.load_heros(rechercheHistoryHeroCommand.getHerosId()).getHistory();
    }
}
