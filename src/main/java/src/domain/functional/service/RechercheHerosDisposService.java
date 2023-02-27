package src.domain.functional.service;

import src.domain.ports.client.RechercheHerosDispoUseCase;
import src.domain.ports.server.HerosPersistenceSpi;
import src.domain.functional.model.Heros;

import java.util.List;

public class RechercheHerosDisposService implements RechercheHerosDispoUseCase {
    private final HerosPersistenceSpi herosRepository;

    public RechercheHerosDisposService(HerosPersistenceSpi herosRepository) {
        this.herosRepository = herosRepository;
    }

    @Override
    public List<Heros> rechercheListeHerosDispos() {
        return herosRepository.findAllHeros();
    }
}
