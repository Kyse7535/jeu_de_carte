package application.services;

import application.port.in.UseCases.RechercheHerosDispoUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Heros;

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
