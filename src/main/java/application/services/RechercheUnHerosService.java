package application.services;

import application.port.in.DTOs.RechercheUnHerosCommand;
import application.port.in.UseCases.RechercheUnHerosUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Heros;


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
