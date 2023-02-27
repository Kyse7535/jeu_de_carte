package src.domain.functional.service;

import src.domain.functional.DTOs.RechercheHistoryHeroCommand;
import src.domain.ports.client.RechercheHistoryHeroUseCase;
import src.domain.ports.server.HerosPersistenceSpi;
import src.domain.functional.model.Combat;

import java.util.List;

public class RechercheHistoryHeroService implements RechercheHistoryHeroUseCase {

    private final HerosPersistenceSpi repository;

    public RechercheHistoryHeroService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public List<Combat> combatHistory(RechercheHistoryHeroCommand rechercheHistoryHeroCommand) {
        return repository.load_heros(rechercheHistoryHeroCommand.getHerosId()).getHistory();
    }
}
