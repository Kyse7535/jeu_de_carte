package src.domain.functional.service;

import src.domain.functional.DTOs.RechercheUnHerosCommand;
import src.domain.ports.client.RechercheUnHerosUseCase;
import src.domain.ports.server.HerosPersistenceSpi;
import src.domain.functional.model.Heros;


public class RechercheUnHerosService implements RechercheUnHerosUseCase {
    private final HerosPersistenceSpi repository;

    public RechercheUnHerosService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public Heros rechercheHerosDispo(RechercheUnHerosCommand rechercheUnHerosCommand) {
        return repository.load_heros(String.valueOf(rechercheUnHerosCommand.id));
    }
}
